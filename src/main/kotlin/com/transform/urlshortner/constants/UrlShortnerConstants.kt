package com.transform.urlshortner.constants

class UrlShortnerConstants {
    companion object {
        var DOMAIN: String= "http://shortUrl/"
        var POSSIBLE_CHAR_STRING: String= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        var BASE: Int =62
        val SHORT_URL_NOT_FOUND: String = "short URL you specified does not exists."
        val SERVICE_EXCEPTION: String = "Exception Occoured: {}"
    }
}