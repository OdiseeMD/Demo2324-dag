package be.odisee.binaryconverter.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BinaryConverterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    fun onDecimalNumberChanged(value: String) {
        _uiState.update {
            it.copy(decimalString = value, decimalIsError = value.toLongOrNull() == null)
        }
    }

    fun onConvertClicked() {
        _uiState.update {
            it.copy(binaryString = it.decimalString.toInt().toString(2))
        }
    }
}