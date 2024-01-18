package be.odisee.todo.ui.addscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import be.odisee.todo.R
import be.odisee.todo.ui.theme.TodoTheme

@Composable
fun AddScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit
) {
    val viewmodel = viewModel<AddViewModel>()
    val state by viewmodel.state.collectAsState()

    val apiState = state.apiState

    if (apiState is AddApiState.Success) {
        LaunchedEffect(Unit) {
            navigateBack()
        }
    }

    Column(
        modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.Top)
    ) {

        if (apiState is AddApiState.Error) {
            Text(text = apiState.message, color = MaterialTheme.colorScheme.error)
        }
        TextField(
            value = state.title,
            onValueChange = {
                viewmodel.onTitleChanged(it)
            }, label = {
                Text(text = stringResource(id = R.string.title))
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = state.description, onValueChange = {
                viewmodel.onDescriptionChanged(it)
            },
            label = {
                Text(text = stringResource(id = R.string.description))
            },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(value = state.dueDate, onValueChange = {
            viewmodel.onDueDateChanged(it)
        }, label = {
            Text(text = stringResource(id = R.string.due_date))
        }, singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { viewmodel.addItem() },
            modifier = Modifier.fillMaxWidth(),
            enabled = apiState != AddApiState.Loading
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.AddCircleOutline, contentDescription = null)
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = stringResource(id = R.string.add_item))
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun AddScreenPreview() {
    TodoTheme {
        AddScreen(navigateBack = {})
    }
}