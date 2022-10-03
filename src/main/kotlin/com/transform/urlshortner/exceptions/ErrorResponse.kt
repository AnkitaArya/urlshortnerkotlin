package com.transform.urlshortner.exceptions

class ErrorResponse {

    /**
     * the errorCode
     */
    private var errorCode = 0

    /**
     * the message
     */
    private var message: String? = null


    constructor(msg: String?, errorCode: Int) {
        this.errorCode = errorCode
        this.message = msg
    }


    /**
     * gets the errorcode
     * @return errorCode
     */
    fun getErrorCode(): Int {
        return errorCode
    }

    /**
     * sets the errorcode
     * @param errorCode
     */
    fun setErrorCode(errorCode: Int) {
        this.errorCode = errorCode
    }

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String?) {
        this.message = message
    }


}