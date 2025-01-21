package vbn.base.kmpapp.features.book.presentation.book_list

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import vbn.base.kmpapp.core.presentation.base.BaseViewModel

class BookListViewModel: BaseViewModel() {
    private val _state = MutableStateFlow(BookListState())
    val state = _state.asStateFlow()

    fun onAction(action: BookListAction) {
        when(action) {
            is BookListAction.OnSearchQueryChange -> {
                _state.update {
                    println("NINVB => query ${action.query}")
                    it.copy(searchQuery = action.query)
                }
            }

            is BookListAction.OnBookClick -> {

            }

            is BookListAction.OnTabSelected -> {
                _state.update {
                    it.copy(selectedTabIndex = action.index)
                }
            }
        }
    }
}