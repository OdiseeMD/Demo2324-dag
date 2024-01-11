package be.odisee.logindemo.ui

import androidx.lifecycle.ViewModel
import be.odisee.logindemo.data.UserRepository
import be.odisee.logindemo.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUIState())

    val uiState = _uiState.asStateFlow()

    fun onUsernameUpdate(username: String) {
        _uiState.update {
            it.copy(
                username = username,
                invalidUsername = UserRepository.users.firstOrNull { it.username == username } != null)
        }
        updateRegisterButton()
    }

    fun onPasswordUpdate(password: String) {
        _uiState.update {
            it.copy(password = password, passwordDoesntMatch = password != it.passwordCheck)
        }
        updateRegisterButton()
    }

    fun onPasswordCheckUpdate(passwordCheck: String) {
        _uiState.update {
            it.copy(
                passwordCheck = passwordCheck,
                passwordDoesntMatch = passwordCheck != it.password
            )
        }
        updateRegisterButton()
    }

    fun onEmailUpdate(email: String) {
        _uiState.update {
            it.copy(email = email)
        }
        updateRegisterButton()
    }

    fun register() {
        val user = User(uiState.value.username, uiState.value.password, uiState.value.email)
        UserRepository.users.add(user)
    }

    private fun updateRegisterButton() {
        _uiState.update {
            it.copy(registerButtonEnabled = !it.passwordDoesntMatch && !it.invalidUsername && it.username.isNotBlank() && it.password.isNotBlank() && it.email.isNotBlank())
        }
    }
}


