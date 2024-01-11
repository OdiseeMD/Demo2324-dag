package be.odisee.binaryconverter.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import be.odisee.binaryconverter.R
import be.odisee.binaryconverter.ui.theme.BinaryConverterTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BinaryConvertApp(modifier: Modifier = Modifier) {

    val viewModel: BinaryConverterViewModel = viewModel()
    val state by viewModel.uiState.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        TextField(
            value = state.decimalString,
            onValueChange = {
                viewModel.onDecimalNumberChanged(it)
            },
            isError = state.decimalIsError)
        Button(
            onClick = { viewModel.onConvertClicked() },
            enabled = !state.decimalIsError
        ) {
            Text(stringResource(R.string.convert))
        }

        Text(text = stringResource(R.string.binair_getal_is, state.binaryString))
    }
}

@Preview(showSystemUi = true)
@Composable
fun BinaryConverterAppPreview() {
    BinaryConverterTheme {
        BinaryConvertApp(
            modifier = Modifier.fillMaxSize()
        )
    }
}