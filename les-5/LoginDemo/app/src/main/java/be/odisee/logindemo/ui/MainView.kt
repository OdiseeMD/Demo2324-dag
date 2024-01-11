package be.odisee.logindemo.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import be.odisee.logindemo.R

@Composable
fun MainView(sendMail: () -> Unit) {
    Box {

        Button(onClick = sendMail) {
            Text(text = stringResource(R.string.send_mail))
        }
    }
}