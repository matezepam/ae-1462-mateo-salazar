package com.pucetec.ae1473exam1.controllers

import com.pucetec.ae1473exam1.dto.BookRequest
import com.pucetec.ae1473exam1.dto.BookResponse
import com.pucetec.ae1473exam1.services.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/books")
class BookController(
    private val bookService: BookService
) {

    @PostMapping
    fun createBook(
        @RequestBody bookRequest: BookRequest
    ): BookResponse {

        return bookService.createBook(bookRequest)
    }

    @GetMapping
    fun getAllBooks(): List<BookResponse> {

        return bookService.getAllBooks()
    }
}