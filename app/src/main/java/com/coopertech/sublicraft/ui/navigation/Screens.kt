package com.coopertech.sublicraft.ui.navigation

import com.coopertech.sublicraft.R
import kotlinx.serialization.Serializable

sealed interface  Route {
    @Serializable data object PrintHome : Route
    @Serializable data object ExploreScreen : Route
    @Serializable data object FavoritesScreen : Route
    @Serializable data object PostDetail : Route
    @Serializable data object AddPost : Route
    @Serializable data object LoginScreen : Route
}

data class SubliTopLevelDestination<T : Any>(val name: String, val route: T, val icon: Int)


val TOP_LEVEL_DESTINATIONS = listOf(
    SubliTopLevelDestination(
        name = "PrintHome",
        route = Route.PrintHome,
        icon = R.drawable.round_print_24
    ),
    SubliTopLevelDestination(
        name = "ExploreScreen",
        route = Route.ExploreScreen,
        icon = R.drawable.ic_explore
    ),
    SubliTopLevelDestination(
        name = "FavoritesScreen",
        route = Route.FavoritesScreen,
        icon = R.drawable.baseline_favorite_border
    )
)
