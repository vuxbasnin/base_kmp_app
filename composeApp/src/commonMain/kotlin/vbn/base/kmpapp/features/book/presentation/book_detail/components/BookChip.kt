package vbn.base.kmpapp.features.book.presentation.book_detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

enum class ChipSize {
    SMALL, REGULAR
}

@Composable
fun BookChip(
    modifier: Modifier = Modifier,
    isSmall: ChipSize = ChipSize.REGULAR,
    chipContent: @Composable () -> Unit
) {
    Box(
        modifier = modifier
    )
}