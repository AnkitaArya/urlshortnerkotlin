package com.transform.urlshortner.exceptions


class ResourceNotFoundException : RuntimeException {

    public override lateinit var message : String

   constructor(message: String) {
        this.message = message;
    }
    fun getmessage(): String? {
        return message
    }

    fun setmessage(errMsg: String) {
        this.message = errMsg
    }

}