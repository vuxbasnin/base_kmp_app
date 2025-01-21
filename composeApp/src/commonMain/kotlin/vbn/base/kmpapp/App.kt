package vbn.base.kmpapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.jetbrains.compose.ui.tooling.preview.Preview
import vbn.base.kmpapp.features.book.presentation.book_list.BookListScreenRoot
import vbn.base.kmpapp.features.book.presentation.book_list.BookListViewModel

@Composable
@Preview
fun App() {
    BookListScreenRoot(
        viewModel = remember { BookListViewModel() },
        onBookClick = {
            
        }
    )
}