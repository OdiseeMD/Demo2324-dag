package be.odisee.logindemo.ui

data class LoginUIState(
    val username: String = "",
    val password: String = "",
    val loginFailed: Boolean = false
)
