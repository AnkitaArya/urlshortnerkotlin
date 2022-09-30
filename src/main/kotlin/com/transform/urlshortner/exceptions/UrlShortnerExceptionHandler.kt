package com.transform.urlshortner.exceptions

import org.springframework.http.HttpStatus

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler


class UrlShortnerExceptionHandler : Exception() {

    @ExceptionHandler(value = arrayOf(UrlShortnerServiceException::class))
    fun handlerForAppManagerServiceException(ex: UrlShortnerServiceException): ResponseEntity<ErrorResponse?>? {
        if (ex.getStatusCode() === 0) {
            ex.setStatusCode(HttpStatus.BAD_REQUEST.value())
        }
        return ResponseEntity(
            ErrorResponse(ex.getMessageDetails(), ex.getStatusCode()),
            HttpStatus.valueOf(ex.getStatusCode())
        )
    }

    /*@ExceptionHandler(value = arrayOf(ResourceNotFoundException::class))
    fun handlerForResourceNotFoundException(ex: ResourceNotFoundException): ResponseEntity<ErrorResponse?>? {
        return ResponseEntity(
            ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value()),
            HttpStatus.NOT_FOUND
        )
    }*/

}