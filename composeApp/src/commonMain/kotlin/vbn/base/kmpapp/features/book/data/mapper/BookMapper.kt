package vbn.base.kmpapp.features.book.data.mapper

import vbn.base.kmpapp.features.book.data.database.BookEntity
import vbn.base.kmpapp.features.book.data.dto.SearchedBookDto
import vbn.base.kmpapp.features.book.domain.Book

fun SearchedBookDto.toBook(): Book {
    return Book(
        id = id.substringAfterLast("/"),
        title = title,
        imageUrl = if (coverKey != null) {
            "https://covers.openlibrary.org/b/olid/${coverKey}-L.jpg"
        } else {
            "https://covers.openlibrary.org/b/id/${coverAlternativeKey}-L.jpg"
        },
        authors = authorNames ?: emptyList(),
        description = null,
        languages = languages ?: emptyList(),
        firstPublishYear = firstPublishYear?.toString(),
        averageRating = ratingsAverage,
        ratingCount = ratingsCount,
        numPages = numberPagesMedian,
        numEditions = numEditions
    )
}

fun Book.toBookEntity(): BookEntity {
    return BookEntity(
        id = id.toString(),
        title = title.toString(),
        description = description,
        imageUrl = imageUrl,
        languages = languages ?: listOf(),
        authors = authors ?: listOf(),
        firstPublishYear = firstPublishYear,
        ratingsAverage = averageRating,
        ratingCount = ratingCount,
        numPagesMedian = numPages,
        numEditions = numEditions
    )
}

fun BookEntity.toBook(): Book {
    return Book(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        languages = languages,
        authors = authors,
        firstPublishYear = firstPublishYear,
        averageRating = ratingsAverage,
        ratingCount = ratingCount,
        numPages = numPagesMedian,
        numEditions = numEditions
    )
}