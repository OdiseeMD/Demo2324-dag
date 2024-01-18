package be.odisee.tools.ui.snackbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun SnackBarScreen(modifier: Modifier = Modifier, snackbarHostState: SnackbarHostState) {

    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            scope.launch {
                snackbarHostState.showSnackbar("Example snackbar")
            }
        }) {
            Text(text = "simple snackbar ")
        }

        Button(onClick = {
            scope.launch {
                val result = snackbarHostState.showSnackbar(
                    "Example snackbar",
                    "label",
                    withDismissAction = true
                )
                when (result) {
                    SnackbarResult.Dismissed -> snackbarHostState.showSnackbar("canceled")
                    SnackbarResult.ActionPerformed -> snackbarHostState.showSnackbar("action performed")
                }
            }
        }) {
            Text(text = "Snackbar with action")
        }
    }
}