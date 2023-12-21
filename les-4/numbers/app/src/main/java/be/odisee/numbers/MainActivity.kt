package be.odisee.numbers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.odisee.numbers.ui.theme.NumbersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NumbersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NumbersList()
                }
            }
        }
    }
}

@Composable
fun NumbersList(modifier: Modifier = Modifier) {

    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(100) {
            ColoredText(text = it.toString())
        }
    }
}

@Composable
fun ColoredText(text: String) {
    val color by remember {
        mutableStateOf(Color((0..255).random(), (0..255).random(), (0..255).random()))
    }
    Text(
        text = text, modifier = Modifier
            .background(color)
            .fillMaxWidth()
            .padding(16.dp)
    )

}

@Preview(showSystemUi = true)
@Composable
fun NumbersListPreview() {
    NumbersTheme {
        NumbersList()
    }
}

