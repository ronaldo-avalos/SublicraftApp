package com.coopertech.sublicraft

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.coopertech.sublicraft.navigation.MainScreens
import com.coopertech.sublicraft.navigation.PostDetail
import com.coopertech.sublicraft.presentation.FavoritesScreen
import com.coopertech.sublicraft.presentation.PrintHomeScreen
import com.coopertech.sublicraft.presentation.explore.ExploreScreen
import com.coopertech.sublicraft.presentation.explore.PostDetailScreen

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    val screens = listOf(MainScreens.PrintHome, MainScreens.Explore, MainScreens.Favorites)

    Scaffold(
        modifier = modifier,
        bottomBar = {
            NavigationBar {
                screens.forEach { screen ->
                    val isSelected = navController.currentBackStackEntryAsState().value?.destination?.route == screen.route
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            if (!isSelected) {
                                navController.navigate(screen.route) {
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    // on the back stack as users select items
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = screen.icon),
                                contentDescription = screen.label
                            )
                        },
                        label = { Text(text = screen.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MainScreens.PrintHome.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(MainScreens.PrintHome.route) { PrintHomeScreen() }
            composable(MainScreens.Explore.route) { ExploreScreen{
                navController.navigate(PostDetail)
            } }
            composable(MainScreens.Favorites.route) { FavoritesScreen() }

           composable<PostDetail>{
               PostDetailScreen(postId = "", onBack = {navController.popBackStack() })
           }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun MainPreview() {
    MainScreen()
}
