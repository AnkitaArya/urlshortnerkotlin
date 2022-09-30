package com.transform.urlshortner.exceptions

class UrlShortnerServiceException(statusCode: Int, message: Any?) : Exception() {

    /**
     * default serialVersionUID
     */
    private val serialVersionUID = 1L

    fun UrlShortnerServiceException() {
    }

    fun UrlShortnerServiceException(statusCode: Int, messageDetails: String?) {
        this.statusCode = statusCode
        this.messageDetails = messageDetails
    }

    private var statusCode = 0

    private var messageDetails: String? = null

    fun getStatusCode(): Int {
        return statusCode
    }

    fun setStatusCode(statusCode: Int) {
        this.statusCode = statusCode
    }

    fun getMessageDetails(): String? {
        return messageDetails
    }

    fun setMessageDetails(messageDetails: String?) {
        this.messageDetails = messageDetails
    }

}