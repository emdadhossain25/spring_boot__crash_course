package com.emdad.spring.spring_boot_crash_course

import jakarta.websocket.server.PathParam
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/quotes")
class QuoteController {
    val quotes = mutableListOf<QuoteDto>()

    @GetMapping()
    fun loadQuotes(): List<QuoteDto> {
        return quotes
    }

    @PostMapping
    fun postQuote(
        @RequestBody quoteDto: QuoteDto,
    ): QuoteDto {
        quotes.add(quoteDto)
        return quoteDto
    }

    @PutMapping
    fun putQuote(
        @RequestBody quoteDto: QuoteDto,
    ): QuoteDto {
        val index = quotes.indexOfFirst { it.id == quoteDto.id }
        quotes[index] = quoteDto
        return quoteDto
    }

    @DeleteMapping("/{id}")
    fun deleteQuote(
        @PathVariable("id")id: Long
    ) {
        val quoteToDelete = quotes.find { it.id == id }
        if (quoteToDelete != null) {
            quotes.remove(quoteToDelete)
        }else{
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }

}