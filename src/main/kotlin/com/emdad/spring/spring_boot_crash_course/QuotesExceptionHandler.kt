package com.emdad.spring.spring_boot_crash_course

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ResponseStatusException

@RestControllerAdvice
class QuotesExceptionHandler {

    @ExceptionHandler(QuotesNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun onQuoteNotFound(e: QuotesNotFoundException) = mapOf(
        "errorCode" to "QUOTES_NOT_FOUND",
        "message" to e.message
    )
}