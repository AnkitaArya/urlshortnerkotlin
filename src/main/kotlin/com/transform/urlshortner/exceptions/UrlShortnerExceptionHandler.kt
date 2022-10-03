package com.transform.urlshortner.exceptions

import org.springframework.http.HttpStatus

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class UrlShortnerExceptionHandler : Exception() {

    @ExceptionHandler(value = [UrlShortnerServiceException::class])
    fun handlerForAppManagerServiceException(ex: UrlShortnerServiceException): ResponseEntity<ErrorResponse?>? {
        if (ex.getStatusCode() === 0) {
            ex.setStatusCode(HttpStatus.BAD_REQUEST.value())
        }
        return ResponseEntity(
            ErrorResponse(ex.getMsg(), ex.getStatusCode()),
            HttpStatus.valueOf(ex.getStatusCode())
        )
    }

    @ExceptionHandler(value = [ResourceNotFoundException::class])
    fun handlerForResourceNotFoundException(ex: ResourceNotFoundException): ResponseEntity<ErrorResponse?>? {
        return ResponseEntity(
            ErrorResponse(ex.getmessage(), HttpStatus.NOT_FOUND.value()),
            HttpStatus.NOT_FOUND
        )
    }

    @ExceptionHandler(value = [Exception::class])
    fun handlerForException(ex: Exception): ResponseEntity<ErrorResponse?>? {
        return ResponseEntity(
            ErrorResponse(ex.message, HttpStatus.NOT_FOUND.value()),
            HttpStatus.NOT_FOUND
        )
    }


}