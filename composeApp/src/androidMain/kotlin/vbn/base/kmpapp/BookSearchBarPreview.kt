package vbn.base.kmpapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import vbn.base.kmpapp.features.book.presentation.book_list.components.BookSearchBar

@Preview
@Composable
fun BookSearchBarPreview() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            BookSearchBar(
                searchQuery = "",
                onSearchQueryChange = {},
                onImeSearch = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}