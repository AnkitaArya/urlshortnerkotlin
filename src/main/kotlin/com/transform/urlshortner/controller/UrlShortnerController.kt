package com.transform.urlshortner.controller

import com.transform.urlshortner.domain.UrlShortnerResource
import com.transform.urlshortner.service.UrlShortnerServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import mu.KotlinLogging


@RestController
@RequestMapping("/rest/url")
class UrlShortnerController @Autowired constructor(
    private val shortnerService: UrlShortnerServiceImpl
){
   private val logger = KotlinLogging.logger {}

    @PutMapping
    fun shortenUrl(@RequestBody longUrl: String?): ResponseEntity<UrlShortnerResource?>? {
        logger.debug("Generating short url for {}", longUrl)
        return ResponseEntity.ok(shortnerService?.shortenUrl(longUrl))
    }

    @GetMapping
    fun getLongUrl(@RequestParam("url") url: String?): ResponseEntity<UrlShortnerResource?>? {
        logger.debug("Fetching long url for {}", url)
        return ResponseEntity.ok(shortnerService?.getFullurl(url))
    }


}