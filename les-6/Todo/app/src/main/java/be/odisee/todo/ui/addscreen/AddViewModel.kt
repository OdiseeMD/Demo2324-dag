package be.odisee.todo.ui.addscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.odisee.todo.model.StringResponse
import be.odisee.todo.model.Todo
import be.odisee.todo.network.TodoApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import retrofit2.HttpException
import java.util.UUID

class AddViewModel : ViewModel() {

    private val _state = MutableStateFlow(AddState())
    val state = _state.asStateFlow()

    fun onTitleChanged(title: String) {
        _state.update {
            it.copy(title = title)
        }
    }

    fun onDescriptionChanged(description: String) {
        _state.update {
            it.copy(description = description)
        }
    }

    fun onDueDateChanged(dueDate: String) {
        _state.update {
            it.copy(dueDate = dueDate)
        }
    }

    fun addItem() {
        val item = Todo(
            id = UUID.randomUUID().toString(),
            title = state.value.title,
            description = state.value.description,
            dueDate = if (state.value.dueDate.isBlank()) null else state.value.dueDate
        )

        _state.update {
            it.copy(apiState = AddApiState.Loading)
        }
        viewModelScope.launch {
            try {
                TodoApi.retrofitService.addTodo(item)
                _state.update {
                    it.copy(apiState = AddApiState.Success)
                }
            } catch (ex: HttpException) {
                Log.d("AddViewModel", ex.message.toString())
                val errorbody = ex.response()?.errorBody()?.string()

                val response = errorbody?.let { Json.decodeFromString<StringResponse>(it) }
                _state.update {
                    it.copy(apiState = AddApiState.Error(response?.message ?: "Unknown Error"))
                }

            } catch (ex: Exception) {
                Log.d("AddViewModel", ex.message.toString())
                _state.update {
                    it.copy(apiState = AddApiState.Error("Unknown Error"))
                }
            }
        }
    }
}
