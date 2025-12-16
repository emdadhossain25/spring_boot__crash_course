package com.emdad.spring.spring_boot_crash_course

class QuotesNotFoundException(
    private val id: Long
) : RuntimeException(
    "A quote with ID $id not found"
)