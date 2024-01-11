package be.odisee.logindemo.ui

import androidx.lifecycle.ViewModel
import be.odisee.logindemo.data.UserRepository
import be.odisee.logindemo.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUIState())
    val uiState = _uiState.asStateFlow()

    fun onPasswordUpdate(password: String) {
        _uiState.update {
            it.copy(password = password, loginFailed = false)
        }
    }

    fun onUsernameUpdate(username: String) {
        _uiState.update {
            it.copy(username = username, loginFailed = false)
        }
    }

    fun login(): User? {
        val user =
            UserRepository.users.firstOrNull { it.username == _uiState.value.username && it.password == _uiState.value.password }

        _uiState.update {
            it.copy(loginFailed = user == null)
        }

        return user
    }
}
