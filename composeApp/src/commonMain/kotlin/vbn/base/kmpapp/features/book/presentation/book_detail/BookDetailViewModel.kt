package vbn.base.kmpapp.features.book.presentation.book_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import vbn.base.kmpapp.app.Route
import vbn.base.kmpapp.features.book.domain.BookRepository

class BookDetailViewModel(
    private val bookRepository: BookRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(BookDetailState())
    val state = _state.onStart {
        observeFavoriteStatus()
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000L),
        _state.value
    )

    private val bookId = savedStateHandle.toRoute<Route.BookDetail>().id

    fun onAction(action: BookDetailAction) {
        when (action) {
            is BookDetailAction.OnSelectedBookChange -> {
                _state.update {
                    it.copy(book = action.book)
                }
            }

            is BookDetailAction.OnFavoriteClick -> {
                viewModelScope.launch {
                    if (state.value.isFavorite) {
                        bookRepository.deleteFromFavorites(bookId.toString())
                    } else {
                        state.value.book?.let {
                            bookRepository.markAsFavorite(it)
                        }
                    }
                }
            }

            else -> Unit
        }
    }

    private fun observeFavoriteStatus() {
        bookRepository.isBookFavorite(bookId.toString())
            .onEach { isFavorite ->
                _state.update { it.copy(isFavorite = isFavorite) }
            }
            .launchIn(viewModelScope)
    }
}