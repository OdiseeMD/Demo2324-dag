package be.odisee.logindemo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import be.odisee.logindemo.R
import be.odisee.logindemo.model.User
import be.odisee.logindemo.ui.theme.LoginDemoTheme

@Composable
fun LoginView(
    modifier: Modifier = Modifier,
    onRegisterClicked: () -> Unit,
    onLoginClicked: (User) -> Unit
) {

    val viewModel = viewModel<LoginViewModel>()
    val state by viewModel.uiState.collectAsState()
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (state.loginFailed) {
            Text(
                text = stringResource(id = R.string.login_failed),
                color = MaterialTheme.colorScheme.error
            )
        }
        TextField(
            value = state.username,
            onValueChange = { viewModel.onUsernameUpdate(it) },
            label = {
                Text(stringResource(R.string.username))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )
        TextField(
            value = state.password,
            onValueChange = { viewModel.onPasswordUpdate(it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            label = {
                Text(stringResource(R.string.password))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )
        Button(
            onClick = {
                val result = viewModel.login()
                if (result != null) {
                    onLoginClicked(result)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            Text(text = stringResource(R.string.login))
        }

        Button(
            onClick = onRegisterClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            Text(text = stringResource(R.string.register))
        }

    }
}

@Composable
@Preview
fun LoginViewPreview() {
    LoginDemoTheme {
        LoginView(onRegisterClicked = {}, onLoginClicked = {})
    }
}