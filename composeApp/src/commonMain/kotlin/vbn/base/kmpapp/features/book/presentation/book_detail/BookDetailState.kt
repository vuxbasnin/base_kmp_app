package vbn.base.kmpapp.features.book.presentation.book_detail

import vbn.base.kmpapp.features.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null
)
