package vbn.base.kmpapp.features.book.domain

import vbn.base.kmpapp.core.domain.DataError
import vbn.base.kmpapp.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
}