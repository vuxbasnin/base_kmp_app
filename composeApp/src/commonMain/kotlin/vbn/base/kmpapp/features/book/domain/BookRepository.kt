package vbn.base.kmpapp.features.book.domain

import kotlinx.coroutines.flow.Flow
import vbn.base.kmpapp.core.domain.DataError
import vbn.base.kmpapp.core.domain.EmptyResult
import vbn.base.kmpapp.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>

    fun getFavoriteBooks(): Flow<List<Book>>
    fun isBookFavorite(id: String): Flow<Boolean>
    suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local>
    suspend fun deleteFromFavorites(id: String)
}