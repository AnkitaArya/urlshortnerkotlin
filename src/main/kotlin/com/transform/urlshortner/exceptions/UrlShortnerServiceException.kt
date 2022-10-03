package com.transform.urlshortner.exceptions

class UrlShortnerServiceException() : Exception() {

    private var statusCode = 0

    private var msg: String? = null

    constructor(statusCode: Int, message: String?) : this() {
        this.statusCode = statusCode
        this.msg = message
    }

    fun getStatusCode(): Int {
        return statusCode
    }

    fun setStatusCode(statusCode: Int) {
        this.statusCode = statusCode
    }

    fun getMsg(): String? {
        return msg
    }

    fun setMsg(messageDetails: String?) {
        this.msg = messageDetails
    }

}