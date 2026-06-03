package com.pucetec.ae1473exam1.services

import com.pucetec.ae1473exam1.dto.BookRequest
import com.pucetec.ae1473exam1.dto.BookResponse
import com.pucetec.ae1473exam1.entities.Book
import com.pucetec.ae1473exam1.repositories.BookRepository
import org.springframework.stereotype.Service
import kotlin.math.round

@Service
class BookService(
    private val bookRepository: BookRepository
) {

    fun createBook(bookRequest: BookRequest): BookResponse {

        val normalizedTitle = normalizeText(bookRequest.title)
        val normalizedAuthor = normalizeText(bookRequest.author)

        val book = Book(
            title = normalizedTitle,
            author = normalizedAuthor,
            priceUsd = bookRequest.priceUsd
        )

        val savedBook = bookRepository.save(book)

        return toResponse(savedBook)
    }

    fun getAllBooks(): List<BookResponse> {

        return bookRepository.findAll()
            .map { book ->
                toResponse(book)
            }
            .sortedBy { bookResponse ->
                bookResponse.title
            }
    }

    private fun toResponse(book: Book): BookResponse {

        return BookResponse(
            id = book.id,
            title = book.title,
            author = book.author,
            slug = createSlug(book.title),
            priceUsd = book.priceUsd,
            finalPrice = calculateFinalPrice(book.priceUsd)
        )
    }

    private fun normalizeText(text: String): String {

        return text.trim()
            .split(" ")
            .filter { word ->
                word.isNotBlank()
            }
            .joinToString(" ") { word ->
                word.lowercase().replaceFirstChar { firstChar ->
                    firstChar.uppercase()
                }
            }
    }

    private fun createSlug(title: String): String {

        return title.lowercase()
            .replace(" ", "-")
    }

    private fun calculateFinalPrice(priceUsd: Double): Double {

        val priceWithTax = priceUsd * 1.12

        return round(priceWithTax * 100) / 100
    }
}