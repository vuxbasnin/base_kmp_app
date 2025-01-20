package vbn.base.kmpapp.features.book.domain

data class Book(
    val id: String? = null,
    val title: String? = null,
    val imageUrl: String? = null,
    val authors: List<String>? = listOf(),
    val description: String? = null,
    val languages: List<String>? = listOf(),
    val firstPublishYear: String? = null,
    val averageRating: Double? = null,
    val ratingCount: Int? = null,
    val numPages: Int? = null,
    val numEditions: Int? = null,
)
