package be.odisee.timer.ui.theme.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.milliseconds

const val TAG = "TimerViewModel"

class TimerViewModel : ViewModel() {
    private var elapsedTime = 0L
    private val _time = MutableStateFlow(convertLongToTime(elapsedTime))
    val time = _time.asStateFlow()
    private var isActive = true


    fun start() {
        isActive = true
        val startTime = System.currentTimeMillis() - elapsedTime
        viewModelScope.launch {
            Log.d(TAG, this.coroutineContext.toString())
            timer(startTime)
        }
    }

    private suspend fun timer(startTime: Long) {
        withContext(Dispatchers.Default) {
            while (isActive) {
                elapsedTime = System.currentTimeMillis() - startTime
                _time.update {
                    convertLongToTime(elapsedTime / 1000 * 1000)
                }
//            Log.d(TAG, time.value)
            }
        }
    }

    fun reset() {
        elapsedTime = 0L
        _time.update {
            convertLongToTime(elapsedTime)
        }
    }

    fun stop() {
        isActive = false
    }

    private fun convertLongToTime(time: Long): String {
        val duration = time.milliseconds
        return duration.toString()
    }
}
