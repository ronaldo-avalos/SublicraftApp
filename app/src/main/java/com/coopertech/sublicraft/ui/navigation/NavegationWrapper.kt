package com.coopertech.sublicraft.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.coopertech.sublicraft.ui.PrintHomeScreen
import com.coopertech.sublicraft.ui.explore.CreatePostScreen
import com.coopertech.sublicraft.ui.explore.ExploreScreen
import com.coopertech.sublicraft.ui.explore.PostDetailScreen
import com.coopertech.sublicraft.ui.navigation.Route.AddPost
import com.coopertech.sublicraft.ui.navigation.Route.ExploreScreen
import com.coopertech.sublicraft.ui.navigation.Route.FavoritesScreen
import com.coopertech.sublicraft.ui.navigation.Route.PostDetail
import com.coopertech.sublicraft.ui.navigation.Route.PrintHome
import com.coopertech.sublicraft.ui.FavoritesScreen as FavoritesScreen1


@Composable
fun NavegationWrapper(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = PrintHome,
        modifier = modifier
    ) {
        composable<PrintHome> {
            PrintHomeScreen()
        }

        composable<ExploreScreen> {
            ExploreScreen(
                addPostButtonTapped = {
                    navController.navigate(AddPost)
                },
                navigateToDetail = {
                    navController.navigate(PostDetail)
                }
            )
        }

        composable<FavoritesScreen> {
            FavoritesScreen1()
        }

        composable<AddPost>{
            CreatePostScreen {

            }
        }

        composable<PostDetail> {
            PostDetailScreen(postId = "") {
                navController.popBackStack()
            }
        }
    }
}
