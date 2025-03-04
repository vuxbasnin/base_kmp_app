package vbn.base.kmpapp.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import vbn.base.kmpapp.core.data.HttpClientFactory
import vbn.base.kmpapp.features.book.data.database.DatabaseFactory
import vbn.base.kmpapp.features.book.data.database.FavoriteBookDatabase
import vbn.base.kmpapp.features.book.data.network.KtorRemoteBookDataSource
import vbn.base.kmpapp.features.book.data.network.RemoteBookDataSource
import vbn.base.kmpapp.features.book.data.repository.DefaultBookRepository
import vbn.base.kmpapp.features.book.domain.BookRepository
import vbn.base.kmpapp.features.book.presentation.SelectedBookViewModel
import vbn.base.kmpapp.features.book.presentation.book_detail.BookDetailViewModel
import vbn.base.kmpapp.features.book.presentation.book_list.BookListViewModel

expect val platformModule: Module

val sharedModule = module {
    single {
        HttpClientFactory.create(get())
    }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<FavoriteBookDatabase>().favoriteBookDao }

    viewModelOf(::BookDetailViewModel)
    viewModelOf(::BookListViewModel)
    viewModelOf(::SelectedBookViewModel)
}