package br.com.concrete.composemovies.base

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.*
import br.com.concrete.composemovies.R
import br.com.concrete.composemovies.model.Screen
import br.com.concrete.composemovies.model.items
import br.com.concrete.composemovies.ui.theme.ComposeMoviesAppTheme

@Preview(device = Devices.PIXEL_4_XL)
@Composable
fun MoviesApp() {
    val navController = rememberNavController()
    ComposeMoviesAppTheme(darkTheme = false) {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(stringResource(id = R.string.app_name)) })
            },
            bottomBar = { MoviesAppBottomBar(navController) }
        ) {
            NavHost(navController, startDestination = Screen.Movies.route) {
                composable(Screen.Movies.route) { Text("Movies") }
                composable(Screen.Favorites.route) { Text("Favorites") }
            }
        }
    }
}

@Composable
fun MoviesAppBottomBar(
    navController: NavController,
    screen: Screen = Screen.Movies
) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

        items.forEach {
            BottomNavigationItem(
                selected = screen == it,
                icon = { Icon(imageVector = it.icon, stringResource(id = it.titleRes)) },
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo = navController.graph.startDestination
                        launchSingleTop = true
                    }
                },
                label = { Text(stringResource(it.titleRes)) }
            )
        }
    }
}
