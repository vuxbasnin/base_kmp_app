package vbn.base.kmpapp.features.book.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchedBookDto(
    @SerialName("key") val id: String,
    @SerialName("title") val title: String,
    @SerialName("language") val languages: List<String>? = emptyList(),
    @SerialName("cover_i") val coverAlternativeKey: Int? = null,
    @SerialName("author_key") val authorKeys: List<String>? = emptyList(),
    @SerialName("author_name") val authorNames: List<String>? = emptyList(),
    @SerialName("cover_edition_key") val coverKey: Int? = null,
    @SerialName("first_publish_year") val firstPublishYear: Int? = null,
    @SerialName("ratings_average") val ratingsAverage: Double? = null,
    @SerialName("ratings_count") val ratingsCount: Int? = null,
    @SerialName("number_of_pages_median") val numberPagesMedian: Int? = null,
    @SerialName("edition_count") val numEditions: Int? = null,
)