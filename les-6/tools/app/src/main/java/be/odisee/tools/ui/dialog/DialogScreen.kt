package be.odisee.tools.ui.dialog

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import be.odisee.tools.R
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun DialogScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var openAlertDialog by remember { mutableStateOf(false) }
        var openTimeDialog by remember { mutableStateOf(false) }
        var openDateDialog by remember { mutableStateOf(false) }

        MyAlertDialog(openDialog = openAlertDialog, onDismissRequest = { openAlertDialog = false })
        MyTimeDialog(openDialog = openTimeDialog, onDismissRequest = { openTimeDialog = false })
        MyDateDialog(openDialog = openDateDialog, onDismissRequest = { openDateDialog = false })

        Button(onClick = { openAlertDialog = true }) {
            Text(text = stringResource(id = R.string.open_alert))
        }
        Button(onClick = { openTimeDialog = true }) {
            Text(text = stringResource(id = R.string.open_time_dialog))
        }
        Button(onClick = { openDateDialog = true }) {
            Text(text = stringResource(id = R.string.open_date_dialog))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTimeDialog(openDialog: Boolean, onDismissRequest: () -> Unit) {

    val timePickerState = rememberTimePickerState(is24Hour = true)
    if (openDialog) {
        AlertDialog(
            onDismissRequest = onDismissRequest
        ) {
            Card(
                shape = AlertDialogDefaults.shape
            ) {

                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TimePicker(state = timePickerState)
                    Row {
                        TextButton(onClick = onDismissRequest) {
                            Text(text = "Dismiss")
                        }
                        TextButton(onClick = {
                            onDismissRequest()
                            Log.d(
                                "selected time",
                                "${timePickerState.hour} ${timePickerState.minute}"
                            )

                        }) {
                            Text(text = "Confirm")
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDateDialog(openDialog: Boolean, onDismissRequest: () -> Unit) {

    val datePickerState = rememberDatePickerState()
    if (openDialog) {
        DatePickerDialog(
            onDismissRequest = onDismissRequest,
            confirmButton = {
                TextButton(
                    onClick = {
                        onDismissRequest()
                        Log.d("date", datePickerState.selectedDateMillis.toString())
                        Log.d(
                            "date",
                            Instant.fromEpochMilliseconds(datePickerState.selectedDateMillis ?: 0)
                                .toLocalDateTime(
                                    TimeZone.currentSystemDefault()
                                ).date.toString()
                        )
                    },

                    ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = onDismissRequest
                ) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}

@Composable
fun MyAlertDialog(openDialog: Boolean, onDismissRequest: () -> Unit) {

    if (openDialog) {
        AlertDialog(
            onDismissRequest = onDismissRequest,
            title = {
                Text(text = "Title")
            },
            text = {
                Text(text = "Turned on by default")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onDismissRequest()
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        onDismissRequest()
                    }
                ) {
                    Text("Dismiss")
                }
            }
        )
    }
}