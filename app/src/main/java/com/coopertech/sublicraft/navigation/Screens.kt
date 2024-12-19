package com.coopertech.sublicraft.navigation

import com.coopertech.sublicraft.R
import kotlinx.serialization.Serializable


@Serializable
sealed class MainScreens(val route: String, val label: String, val icon: Int) {
    object PrintHome : MainScreens("print", "Print", R.drawable.round_print_24)
    object Explore : MainScreens("explore", "Explorar", R.drawable.ic_explore)
    object Favorites : MainScreens("favorites", "Favoritos", R.drawable.ic_favorites)
}

@Serializable
object PostDetail
