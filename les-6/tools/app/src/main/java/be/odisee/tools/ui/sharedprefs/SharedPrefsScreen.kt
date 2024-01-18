package be.odisee.tools.ui.sharedprefs

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SharedPrefsScreen(modifier: Modifier = Modifier) {
    val viewmodel = viewModel<SharedPrefsViewModel>()

    val state by viewmodel.state.collectAsState()
    Box(modifier = modifier) {

        TextField(
            value = state.name,
            onValueChange = { viewmodel.onNameChanged(it) },
            modifier = Modifier.align(
                Alignment.Center
            )
        )
    }

}