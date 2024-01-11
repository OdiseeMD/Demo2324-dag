package be.odisee.logindemo.ui

data class RegisterUIState(
    val username: String = "",
    val password: String = "",
    val passwordCheck: String = "",
    val email: String = "",
    val invalidUsername: Boolean = false,
    val passwordDoesntMatch: Boolean = false,
    val registerButtonEnabled: Boolean = false
)
