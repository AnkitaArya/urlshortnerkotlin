package com.transform.urlshortner.domain

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include

class UrlShortnerResource {
    @JsonInclude(Include.NON_NULL)
    private var fullurl: String? = null

    @JsonInclude(Include.NON_NULL)
    private var shortUrl: String? = null

    fun getFullurl(): String? {
        return fullurl
    }

    fun setFullurl(fullurl: String?) {
        this.fullurl = fullurl
    }

    fun getShortUrl(): String? {
        return shortUrl
    }

    fun setShortUrl(shortUrl: String?) {
        this.shortUrl = shortUrl
    }
}