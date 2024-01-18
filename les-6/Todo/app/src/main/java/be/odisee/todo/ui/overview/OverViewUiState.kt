package be.odisee.todo.ui.overview

import be.odisee.todo.model.Todo


data class OverViewUiState(
    val apiState: TodoApiState = TodoApiState.Loading
)


sealed interface TodoApiState {
    object Loading : TodoApiState
    data class Success(val data: List<Todo>) : TodoApiState
    object Error : TodoApiState
}
