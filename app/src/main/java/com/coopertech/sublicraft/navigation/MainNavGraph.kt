package com.coopertech.sublicraft.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.coopertech.sublicraft.presentation.FavoritesScreen
import com.coopertech.sublicraft.presentation.PrintHomeScreen
import com.coopertech.sublicraft.presentation.explore.ExploreScreen

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = MainScreens.PrintHome.route
    ) {
        composable(MainScreens.PrintHome.route) { PrintHomeScreen() }
        composable(MainScreens.Explore.route) {
            ExploreScreen {
                navController.navigate("${PostDetail}/${it}") // Navegar al gráfico de detalle con argumentos
            }
        }
        composable(MainScreens.Favorites.route) { FavoritesScreen() }
    }
}
