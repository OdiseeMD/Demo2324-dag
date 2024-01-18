package be.odisee.todo.ui.overview

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.odisee.todo.R
import be.odisee.todo.model.Todo
import be.odisee.todo.ui.theme.TodoTheme

@Composable
fun OverviewScreen(viewmodel: OverviewViewModel, modifier: Modifier = Modifier) {

    val state by viewmodel.state.collectAsState()

    val apiState = state.apiState
    when (apiState) {
        is TodoApiState.Error -> ErrorView(retryAction = { viewmodel.reload() })
        is TodoApiState.Loading -> LoadingView()
        is TodoApiState.Success -> TodoListView(data = apiState.data, checkItem = { id, value ->
            viewmodel.check(id, value)
        })
    }

}

@Composable
fun ErrorView(modifier: Modifier = Modifier, retryAction: () -> Unit) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.Error,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.error,
            modifier = Modifier.size(80.dp)
        )
        Text(text = stringResource(R.string.something_went_wrong))
        Button(onClick = retryAction) {
            Text(text = stringResource(R.string.try_again))
        }
    }
}

@Composable
fun LoadingView(modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CircularProgressIndicator(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(80.dp)
        )
        Text(text = stringResource(R.string.loading))
    }
}

@Composable
fun TodoListView(
    data: List<Todo>,
    modifier: Modifier = Modifier,
    checkItem: (String, Boolean) -> Unit
) {

    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(data) {
            TodoItem(it, checkItem)
        }
    }
}

@Composable
fun TodoItem(item: Todo, checkItem: (String, Boolean) -> Unit) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.animateContentSize(
                spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
        ) {


            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = item.done, onCheckedChange = {

                    checkItem(item.id, !item.done)

                })
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    Text(item.title, style = MaterialTheme.typography.titleMedium)
                    if (item.dueDate != null) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Text(
                                text = item.dueDate.toString(),
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = stringResource(R.string.show_more)
                    )
                }
            }
            if (expanded) {
                Text(
                    text = item.description,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun TodoListViewPreview() {
    TodoTheme {
        TodoListView(
            data = listOf(
                Todo(
                    id = "1",
                    title = "Example 1",
                    description = "Measured fer yer chains Letter of Marque scuppers brigantine draught sloop gibbet shrouds strike colors avast. Parley sloop cutlass Jack Tar tack list ho spanker driver long boat.",
                    dueDate = null,
                    createdDate = "2024-02-02",
                    done = false
                ),
                Todo(
                    id = "2",
                    title = "Example 2",
                    description = "Quarterdeck gally Brethren of the Coast quarter gaff Admiral of the Black rope's end grog keel cackle fruit. Chain Shot nipperkin pillage bucko knave clap of thunder Pirate Round prow handsomely rigging. Jib furl Barbary Coast pressgang hearties swab spike stern haul wind Sail ho",
                    dueDate = "2024-02-02",
                    createdDate = "2024-02-02",
                    done = true
                )
            ),
            checkItem = { _, _ -> }
        )
    }
}