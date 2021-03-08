package br.com.concrete.composemovies.model

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Movie
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.concrete.composemovies.R

sealed class Screen(
    val route: String,
    @StringRes val titleRes: Int,
    val icon: ImageVector
) {
    object Movies : Screen("movies", R.string.title_tab_movies, Icons.Default.Movie)
    object Favorites : Screen("favorites", R.string.title_tab_favorites, Icons.Default.Favorite)
}

val items = listOf(
    Screen.Movies,
    Screen.Favorites,
)

enum class MoviesAppScreen(
    val icon: ImageVector,
    @StringRes val title: Int
) {
    Movies(
        icon = Icons.Default.Movie,
        title = R.string.title_tab_movies
    ),

    Favorites(
        icon = Icons.Default.Favorite,
        title = R.string.title_tab_favorites
    )
}