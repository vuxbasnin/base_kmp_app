package vbn.base.kmpapp.features.book.presentation.book_list.components

import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

enum class TypeBookClickSearchBar {
    NONE, ON_CLICK_SEARCH_QUERY_CHANGE, ON_IMG_SEARCH
}

@Composable
fun BookSearchBar(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onImeSearch: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = searchQuery,
        onValueChange = onSearchQueryChange
    )
}