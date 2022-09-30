package com.transform.urlshortner.exceptions

class ErrorResponse(message: Any?, statusCode: Int) {

    /**
     * the errorCode
     */
    private var errorCode = 0

    /**
     * the message
     */
    private var message: String? = null


    fun ErrorResponse(msg: String?, errorCode: Int) {
        this.errorCode = errorCode
        this.message = msg
    }

    /**
     * to instantiate error response
     */
    fun ErrorResponse() {}

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