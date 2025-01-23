package vbn.base.kmpapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import io.ktor.client.engine.HttpClientEngine
import org.jetbrains.compose.ui.tooling.preview.Preview
import vbn.base.kmpapp.core.data.HttpClientFactory
import vbn.base.kmpapp.features.book.data.network.KtorRemoteBookDataSource
import vbn.base.kmpapp.features.book.data.repository.DefaultBookRepository
import vbn.base.kmpapp.features.book.presentation.book_list.BookListScreenRoot
import vbn.base.kmpapp.features.book.presentation.book_list.BookListViewModel

@Composable
@Preview
fun App(engine: HttpClientEngine) {
    BookListScreenRoot(
        viewModel = remember {
            BookListViewModel(
                bookRepository = DefaultBookRepository(
                    remoteBookDataSource = KtorRemoteBookDataSource(
                        httpClient = HttpClientFactory.create(engine)
                    )
                )
            )
        },
        onBookClick = {

        }
    )
}