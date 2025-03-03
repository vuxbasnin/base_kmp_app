package vbn.base.kmpapp

import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import vbn.base.kmpapp.features.book.presentation.book_list.BookListScreenRoot
import vbn.base.kmpapp.features.book.presentation.book_list.BookListViewModel

@Composable
@Preview
fun App() {
    val viewModel = koinViewModel<BookListViewModel>()
    BookListScreenRoot(
        viewModel = viewModel,
        onBookClick = {

        }
    )
}