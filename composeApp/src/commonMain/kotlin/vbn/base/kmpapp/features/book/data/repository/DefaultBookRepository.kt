package vbn.base.kmpapp.features.book.data.repository

import androidx.sqlite.SQLiteException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import vbn.base.kmpapp.core.domain.DataError
import vbn.base.kmpapp.core.domain.EmptyResult
import vbn.base.kmpapp.core.domain.Result
import vbn.base.kmpapp.core.domain.map
import vbn.base.kmpapp.features.book.data.database.FavoriteBookDao
import vbn.base.kmpapp.features.book.data.mapper.toBook
import vbn.base.kmpapp.features.book.data.mapper.toBookEntity
import vbn.base.kmpapp.features.book.data.network.RemoteBookDataSource
import vbn.base.kmpapp.features.book.domain.Book
import vbn.base.kmpapp.features.book.domain.BookRepository

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
    private val favoriteBookDao: FavoriteBookDao
) : BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map {
                    it.toBook()
                }
            }
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        return favoriteBookDao.getFavoriteBooks()
            .map { bookEntities ->
                bookEntities.map { it.toBook() }
            }
    }

    override fun isBookFavorite(id: String): Flow<Boolean> {
        return favoriteBookDao.getFavoriteBooks()
            .map { bookEntities ->
                bookEntities.any { it.id == id }
            }
    }

    override suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local> {
        return try {
            favoriteBookDao.upsert(book.toBookEntity())
            Result.Success(Unit)
        } catch (e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteFromFavorites(id: String) {
        favoriteBookDao.deleteFavoriteBook(id)
    }
}