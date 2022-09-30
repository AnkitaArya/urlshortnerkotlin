package com.transform.urlshortner.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "URL_ENTITY")
class UrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var urlId: Long? = null

    @Column(name = "SHORT_URL")
    private var shortUrl: String? = null

    @Column(name = "FULL_URL")
    private var fullUrl: String? = null

    fun UrlEntity(fullUrl: String?) {
        this.fullUrl = fullUrl
    }
    fun UrlEntity() {}

    fun UrlEntity(urlId: Long?, shortUrl: String?, fullUrl: String?) {
        this.urlId = urlId
        this.shortUrl = shortUrl
        this.fullUrl = fullUrl
    }


    fun getUrlId(): Long? {
        return urlId
    }

    fun setUrlId(urlId: Long?) {
        this.urlId = urlId
    }


    fun getShortUrl(): String? {
        return shortUrl
    }

    fun setShortUrl(shortUrl: String?) {
        this.shortUrl = shortUrl
    }

    fun getFullUrl(): String? {
        return fullUrl
    }

    fun setFullUrl(fullUrl: String?) {
        this.fullUrl = fullUrl
    }
}