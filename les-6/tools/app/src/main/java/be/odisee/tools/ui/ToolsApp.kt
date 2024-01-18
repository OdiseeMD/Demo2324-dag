package be.odisee.tools.ui

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Dialpad
import androidx.compose.material.icons.filled.Domain
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Snooze
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import be.odisee.tools.R
import be.odisee.tools.ui.dialog.DialogScreen
import be.odisee.tools.ui.menu.MenuScreen
import be.odisee.tools.ui.sharedprefs.SharedPrefsScreen
import be.odisee.tools.ui.snackbar.SnackBarScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ToolsApp(modifier: Modifier = Modifier) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    // Navigation
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen =
        Screen.valueOf(currentBackStackEntry?.destination?.route ?: Screen.Main.name)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(modifier.width(IntrinsicSize.Max)) {
                NavigationDrawerItem(
                    label = { Text(text = Screen.Main.name) },
                    selected = currentScreen == Screen.Main,
                    onClick = {
                        navController.navigate(Screen.Main.name)
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
                NavigationDrawerItem(
                    label = { Text(text = Screen.SharedPrefs.name) },
                    selected = currentScreen == Screen.SharedPrefs,
                    onClick = {
                        navController.navigate(Screen.SharedPrefs.name)
                        scope.launch {

                            drawerState.close()
                        }
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
                NavigationDrawerItem(
                    label = { Text(text = Screen.SnackBar.name) },
                    selected = currentScreen == Screen.SnackBar,
                    onClick = {
                        navController.navigate(Screen.SnackBar.name)
                        scope.launch {

                            drawerState.close()
                        }
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
                NavigationDrawerItem(
                    label = { Text(text = Screen.Menu.name) },
                    selected = currentScreen == Screen.Menu,
                    onClick = {
                        navController.navigate(Screen.Menu.name)
                        scope.launch {

                            drawerState.close()
                        }
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
                NavigationDrawerItem(
                    label = { Text(text = Screen.Dialog.name) },
                    selected = currentScreen == Screen.Dialog,
                    onClick = {
                        navController.navigate(Screen.Dialog.name)
                        scope.launch {

                            drawerState.close()
                        }
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
            }
        },
    ) {
        NavigationScreen(
            toggleDrawer = {
                scope.launch {
                    if (drawerState.isClosed) {
                        drawerState.open()
                    } else {
                        drawerState.close()
                    }
                }
            },
            navController = navController,
            scope = scope
        )
    }
}

@Composable
private fun NavigationScreen(
    toggleDrawer: () -> Unit,
    scope: CoroutineScope,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen =
        Screen.valueOf(currentBackStackEntry?.destination?.route ?: Screen.Main.name)
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    Scaffold(
        topBar = {
            TodoTopAppBar(
                toggleDrawer = toggleDrawer,
                currentScreen = currentScreen,
                canNavigateUp = navController.previousBackStackEntry != null,
                navigateUp = {
                    navController.navigateUp()
                }
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar("FAB clicked")
                }
            }) {
                Icon(imageVector = Icons.Default.QuestionMark, contentDescription = null)
            }
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    label = { Text(text = Screen.Main.name) },
                    selected = currentScreen == Screen.Main,
                    onClick = {
                        navController.navigate(Screen.Main.name)

                    }, icon = {
                        Icon(imageVector = Icons.Default.Domain, contentDescription = null)
                    }
                )
                NavigationBarItem(
                    label = { Text(text = Screen.SharedPrefs.name) },
                    selected = currentScreen == Screen.SharedPrefs,
                    onClick = {
                        navController.navigate(Screen.SharedPrefs.name)
                    }, icon = {
                        Icon(imageVector = Icons.Default.Share, contentDescription = null)
                    }
                )
                NavigationBarItem(
                    label = { Text(text = Screen.SnackBar.name) },
                    selected = currentScreen == Screen.SnackBar,
                    onClick = {
                        navController.navigate(Screen.SnackBar.name)

                    }, icon = {
                        Icon(imageVector = Icons.Default.Snooze, contentDescription = null)
                    }
                )
                NavigationBarItem(
                    label = { Text(text = Screen.Menu.name) },
                    selected = currentScreen == Screen.Menu,
                    onClick = {
                        navController.navigate(Screen.Menu.name)

                    }, icon = {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                    }
                )
                NavigationBarItem(
                    label = { Text(text = Screen.Dialog.name) },
                    selected = currentScreen == Screen.Dialog,
                    onClick = {
                        navController.navigate(Screen.Dialog.name)

                    }, icon = {
                        Icon(imageVector = Icons.Default.Dialpad, contentDescription = null)
                    }
                )
            }
        }
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Main.name,
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
        ) {
            composable(route = Screen.Main.name) {


            }

            composable(route = Screen.SharedPrefs.name) {
                SharedPrefsScreen(modifier = Modifier.fillMaxSize())
            }

            composable(route = Screen.SnackBar.name) {
                SnackBarScreen(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHostState = snackbarHostState
                )
            }
            composable(route = Screen.Menu.name) {
                MenuScreen(modifier = Modifier.fillMaxSize())
            }
            composable(route = Screen.Dialog.name) {
                DialogScreen(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoTopAppBar(
    toggleDrawer: () -> Unit,
    currentScreen: Screen,
    canNavigateUp: Boolean,
    navigateUp: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(stringResource(id = currentScreen.stringId))
        },
        navigationIcon = {
            ToolsNavigationIcon(
                currentScreen,
                toggleDrawer,
                canNavigateUp,
                navigateUp
            )
        },
        actions = {
            ToolsActions()
        }
    )
}

@Composable
fun ToolsActions() {
    var menuExpanded by remember {
        mutableStateOf(false)
    }
    var counter by remember {
        mutableStateOf(1)
    }

    IconButton(onClick = { menuExpanded = !menuExpanded }) {
        Icon(imageVector = Icons.Default.Share, contentDescription = null)
    }

    IconButton(onClick = { menuExpanded = !menuExpanded }) {
        Icon(
            imageVector = Icons.Filled.MoreVert,
            contentDescription = "More",
        )
    }
    DropdownMenu(
        expanded = menuExpanded,
        onDismissRequest = { menuExpanded = false },
    ) {
        repeat(counter) {
            DropdownMenuItem(text = { Text("$counter") }, onClick = {
                menuExpanded = false
                counter++
            })
        }

    }
}

@Composable
fun ToolsNavigationIcon(
    currentScreen: Screen,
    toggleDrawer: () -> Unit,
    canNavigateUp: Boolean,
    navigateUp: () -> Unit
) {
    when (currentScreen) {
        Screen.Main -> {
            IconButton(onClick = toggleDrawer) {
                Icon(
                    imageVector = Icons.Default.Menu, contentDescription = stringResource(
                        id = R.string.open_menu
                    )
                )
            }
        }

        else -> {
            if (canNavigateUp) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(
                            id = R.string.go_back
                        )
                    )
                }
            }
        }
    }
}
