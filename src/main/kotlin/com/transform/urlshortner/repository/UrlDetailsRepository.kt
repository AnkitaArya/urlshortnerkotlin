package com.transform.urlshortner.repository

import com.transform.urlshortner.entity.UrlEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface UrlDetailsRepository : JpaRepository<UrlEntity, Integer> {

    fun findByFullUrl(fullUrl: String?): UrlEntity?
    fun save(urlEntity: UrlEntity?): UrlEntity?
    fun findByShortUrl(shortUrl: String?): UrlEntity?
}