package vbn.base.kmpapp.features.book.data.repository

import vbn.base.kmpapp.core.domain.DataError
import vbn.base.kmpapp.core.domain.Result
import vbn.base.kmpapp.core.domain.map
import vbn.base.kmpapp.features.book.data.mapper.toBook
import vbn.base.kmpapp.features.book.data.network.RemoteBookDataSource
import vbn.base.kmpapp.features.book.domain.Book
import vbn.base.kmpapp.features.book.domain.BookRepository

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
): BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map {
                    it.toBook()
                }
            }
    }
}