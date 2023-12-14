package be.odisee.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.odisee.demo.ui.theme.DemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Form(modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}

@Composable
fun Form(modifier: Modifier = Modifier) {
    var name by remember {
        mutableStateOf("Demo")
    }

    var email by remember {
        mutableStateOf("")
    }

    var checked by remember {
        mutableStateOf(true)
    }
    Column(modifier = modifier) {
        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = {
                Text(text = "Name")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = {
                Text(text = "Email")
            },
            enabled = checked,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )
        EmailSwitch(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(8.dp),
            checked = checked,
            onCheckedChange = {checked = it}
        )
    }
}

@Composable
fun EmailSwitch(modifier: Modifier = Modifier, checked: Boolean, onCheckedChange: (Boolean)-> Unit) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Email enabled")
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}


@Preview(showSystemUi = true)
@Composable
fun FormPreview() {
    DemoTheme {
        Form()
    }
}












