package be.odisee.todo.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import be.odisee.todo.R
import be.odisee.todo.ui.addscreen.AddScreen
import be.odisee.todo.ui.overview.OverviewScreen
import be.odisee.todo.ui.overview.OverviewViewModel

enum class Screens {
    Overview,
    AddItem
}

@Composable
fun TodoApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val overviewViewModel = viewModel<OverviewViewModel>()

    val backStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(topBar = {
        if (backStackEntry?.destination?.route == Screens.Overview.name)
            TodoTopAppBar(overviewViewModel) else {
            TodoTopAppBar()
        }
    }, floatingActionButton = {
        if (backStackEntry?.destination?.route == Screens.Overview.name) {
            FloatingActionButton(onClick = { navController.navigate(Screens.AddItem.name) }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.add_item)
                )
            }
        }
    }) {

        NavHost(
            navController = navController,
            startDestination = Screens.Overview.name,
            modifier = Modifier.padding(it)
        ) {
            composable(Screens.Overview.name) {
                OverviewScreen(overviewViewModel)
            }
            composable(Screens.AddItem.name) {
                AddScreen(navigateBack = {
                    navController.popBackStack()
                    overviewViewModel.reload()
                })
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoTopAppBar(overviewViewModel: OverviewViewModel? = null) {
    TopAppBar(title = {
        Text("Todo")
    }, actions = {
        if (overviewViewModel != null) {

            IconButton(onClick = {
                overviewViewModel.reload()
            }) {
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    contentDescription = "Localized description"
                )
            }
        }
    })
}
