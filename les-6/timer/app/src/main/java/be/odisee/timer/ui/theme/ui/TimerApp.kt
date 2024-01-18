package be.odisee.timer.ui.theme.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import be.odisee.timer.ui.theme.TimerTheme

@Composable
fun TimerApp(modifier: Modifier = Modifier) {

    val viewmodel = viewModel<TimerViewModel>()

    val time by viewmodel.time.collectAsState()
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = time)
        Button(onClick = { viewmodel.start() }) {
            Text("Start")
        }
        Button(onClick = { viewmodel.stop() }) {
            Text("Stop")
        }
        Button(onClick = { viewmodel.reset() }) {
            Text(text = "Reset")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TimeAppPreview(){
    TimerTheme {
        TimerApp()
    }
}