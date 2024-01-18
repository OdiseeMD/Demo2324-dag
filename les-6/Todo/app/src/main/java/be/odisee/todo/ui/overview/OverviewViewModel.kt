package be.odisee.todo.ui.overview

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.odisee.todo.network.TodoApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    private val _state = MutableStateFlow(OverViewUiState())
    val state = _state.asStateFlow()

    init {
        reload()
    }

    fun reload() {
        _state.update { it.copy(apiState = TodoApiState.Loading) }
        viewModelScope.launch {
            try {
                val items = TodoApi.retrofitService.getItems()
                _state.update {
                    Log.d("OverviewViewModel", it.toString())
                    it.copy(apiState = TodoApiState.Success(items.message))
                }
            } catch (ex: Exception) {
                _state.update { it.copy(apiState = TodoApiState.Error) }
            }
        }
    }


    fun check(id: String, value: Boolean) {
        viewModelScope.launch {
            if (value) {
                TodoApi.retrofitService.checkItem(id)
            } else {
                TodoApi.retrofitService.uncheckItem(id)
            }
            reload()
        }
    }
}
