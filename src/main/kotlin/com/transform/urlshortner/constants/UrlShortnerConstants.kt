package com.transform.urlshortner.constants

class UrlShortnerConstants {
    companion object {
        var DOMAIN: String= "http://shortUrl/"
        var POSSIBLE_CHAR_STRING: String= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        var BASE: Int =62
        var regex: String = "^(https|http)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"
        //exception messages
        var SHORT_URL_NOT_FOUND: String = "short URL you specified does not exists."
        var SERVICE_EXCEPTION: String = "Exception Occoured: {}"
        var VALIDATION_EXCEPTION: String = "Validation failed! Please provide valid url"
    }
}