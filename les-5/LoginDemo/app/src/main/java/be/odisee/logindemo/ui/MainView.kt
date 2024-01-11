package be.odisee.logindemo.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import be.odisee.logindemo.R
import be.odisee.logindemo.ui.theme.LoginDemoTheme

@Composable
fun MainView(sendMail: () -> Unit) {
    Box {

        Button(onClick = sendMail) {
            Text(text = stringResource(R.string.send_mail))
        }
    }
}

@Preview (showSystemUi = true)
@Composable
fun MainViewPreview(){
    LoginDemoTheme {
        MainView {

        }
    }
}