package be.odisee.todo.ui.addscreen

data class AddState(
    val title: String = "",
    val description: String = "",
    val dueDate: String = "",
    val apiState: AddApiState = AddApiState.Init
)

sealed interface AddApiState {
    object Init : AddApiState
    object Loading : AddApiState
    object Success : AddApiState
    data class Error(val message: String) : AddApiState
}
