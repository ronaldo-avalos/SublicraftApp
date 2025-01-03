package com.coopertech.sublicraft.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.coopertech.sublicraft.data.remote.firebase.auth.AuthManager
import com.coopertech.sublicraft.ui.navigation.Route.AddPost
import com.coopertech.sublicraft.ui.navigation.Route.ExploreScreen
import com.coopertech.sublicraft.ui.navigation.Route.FavoritesScreen
import com.coopertech.sublicraft.ui.navigation.Route.PostDetail
import com.coopertech.sublicraft.ui.navigation.Route.PrintHome
import com.coopertech.sublicraft.ui.screen.detail.PostDetailScreen
import com.coopertech.sublicraft.ui.screen.explore.ExploreScreen
import com.coopertech.sublicraft.ui.screen.printHome.PrintHomeScreen
import com.coopertech.sublicraft.ui.screen.session.login.LoginScreen
import com.coopertech.sublicraft.ui.screen.favorites.FavoritesScreen as FavoritesScreen1


@Composable
fun NavegationWrapper(
    context: Context,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val authManager = AuthManager(context)

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
//            CreatePostScreen {
//
//            }
        }

        composable<PostDetail> {
            PostDetailScreen(postID = "") {
                navController.popBackStack()
            }
        }

        composable<Route.LoginScreen>{
            LoginScreen(auth = authManager)
        }
    }
}
