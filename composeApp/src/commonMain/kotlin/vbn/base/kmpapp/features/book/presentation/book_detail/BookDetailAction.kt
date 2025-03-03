package vbn.base.kmpapp.features.book.presentation.book_detail

import vbn.base.kmpapp.features.book.domain.Book

sealed interface BookDetailAction {
    data object OnBackClick: BookDetailAction
    data object OnFavoriteClick: BookDetailAction
    data class OnSelectedBookChange(val book: Book): BookDetailAction
}