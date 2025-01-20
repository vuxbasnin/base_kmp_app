package vbn.base.kmpapp.features.book.presentation.book_list

import vbn.base.kmpapp.core.presentation.UiText
import vbn.base.kmpapp.features.book.domain.Book

data class BookListState(
    val searchQuery: String = "",
    val searchResults: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)
