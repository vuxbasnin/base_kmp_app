package vbn.base.kmpapp.features.book.presentation.book_list

import vbn.base.kmpapp.core.presentation.UiText
import vbn.base.kmpapp.features.book.domain.Book

data class BookListState(
    val searchQuery: String = "",
    val searchResults: List<Book> = books,
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)

val books = (1..100).map {
    Book(
        id = it.toString(),
        title = "Book $it",
        imageUrl = "https://test.com",
        authors = listOf("Nin"),
        description = "Description $it",
        languages = emptyList(),
        firstPublishYear = null,
        averageRating = 4.567843,
        ratingCount = 5,
        numPages = 100,
        numEditions = 3
    )
}
