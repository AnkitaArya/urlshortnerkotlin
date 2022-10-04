package com.transform.urlshortner.service

import com.transform.urlshortner.constants.UrlShortnerConstants
import com.transform.urlshortner.domain.UrlShortnerResource
import com.transform.urlshortner.entity.UrlEntity
import com.transform.urlshortner.exceptions.ResourceNotFoundException
import com.transform.urlshortner.exceptions.UrlShortnerServiceException
import com.transform.urlshortner.repository.UrlDetailsRepository
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


private val staticLogger = KotlinLogging.logger {}

@Service
open class UrlShortnerServiceImpl @Autowired constructor(
    private val detailsRepository: UrlDetailsRepository
) {

    @Transactional(rollbackFor = [Exception::class])
    open fun shortenUrl(fullUrl: String?): UrlShortnerResource? {
        val resource = UrlShortnerResource()
        var shortUrl: String? = null
        val domain: String = UrlShortnerConstants.DOMAIN
        //validate the url


        if (fullUrl != null) {
            validateUserInput(fullUrl)
            try {
                //check if the url already exists in DB
                val entity: UrlEntity? = detailsRepository?.findByFullUrl(fullUrl)
                if (entity?.getFullUrl() != null && entity.getShortUrl() != null) {
                    shortUrl = entity.getShortUrl()
                } else {
                    staticLogger.debug("{} does not exist in Db. Thus creating new entry.", fullUrl)
                    var entityCreated = UrlEntity()
                    entityCreated?.setFullUrl(fullUrl)
                    //first save to get generated ID
                    entityCreated = detailsRepository?.save(entityCreated)!!
                    //now encrypt the id
                    val encyId: String? = entityCreated?.getUrlId()?.let { encryptShortUrlId(it) }
                    shortUrl = domain + encyId
                    //save the encryptedId to Db
                    entityCreated.setShortUrl(shortUrl)
                    //update
                    detailsRepository?.save(entityCreated)
                }
                resource.setShortUrl(shortUrl)
            } catch (ex: Exception) {
                staticLogger.error(UrlShortnerConstants.SERVICE_EXCEPTION, ex)
                throw UrlShortnerServiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.message)
            }

        }

        staticLogger.info("{} url is shortened to {}", fullUrl, shortUrl)
        return resource

    }

    private fun encryptShortUrlId(id: Long): String? {
        var id = id
        val possibleChars: CharArray = UrlShortnerConstants.POSSIBLE_CHAR_STRING.toCharArray()
        val base: Int = UrlShortnerConstants.BASE
        val strBldr = StringBuilder()
        while (id > 0) {
            strBldr.insert(0, possibleChars[(id % base).toInt()])
            id /= base
        }

        return strBldr.toString()
    }

    private fun save(entityCreated: UrlEntity?): UrlEntity? {
        return detailsRepository?.save(entityCreated)
    }

    @Transactional(rollbackFor = [Exception::class])
    open fun getFullurl(shortUrl: String?): UrlShortnerResource? {
        val resource = UrlShortnerResource()
        var fullUrl: String? = null
        if (shortUrl != null) {
            //check if the url already exists in DB
            val entity: UrlEntity? = detailsRepository?.findByShortUrl(shortUrl)
            if (entity?.getFullUrl() != null && entity.getShortUrl() != null) {
                fullUrl = entity.getFullUrl()
                resource.setFullurl(fullUrl)
            } else {
                //the URl is not available in system;
                staticLogger.error("{} url is not found in the Db.", shortUrl)
                throw ResourceNotFoundException(UrlShortnerConstants.SHORT_URL_NOT_FOUND)
            }
        }
        return resource
    }

    private fun validateUserInput(fullUrl: String) {
        var pattern = Regex(UrlShortnerConstants.regex)
        if (!fullUrl.matches(pattern))
            throw UrlShortnerServiceException(HttpStatus.BAD_REQUEST.value(), UrlShortnerConstants.VALIDATION_EXCEPTION)
    }

}
