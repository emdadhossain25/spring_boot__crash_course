package com.emdad.spring.spring_boot_crash_course

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping
    fun hello() = "Hello, World!"
}