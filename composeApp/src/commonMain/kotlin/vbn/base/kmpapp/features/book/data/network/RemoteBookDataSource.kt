package vbn.base.kmpapp.features.book.data.network

import vbn.base.kmpapp.core.domain.DataError
import vbn.base.kmpapp.core.domain.Result
import vbn.base.kmpapp.features.book.data.dto.SearchResponseDto

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>
}