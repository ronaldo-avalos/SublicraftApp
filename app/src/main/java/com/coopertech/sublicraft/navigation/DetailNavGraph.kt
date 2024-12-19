package com.coopertech.sublicraft.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.coopertech.sublicraft.presentation.explore.PostDetailScreen

@Composable
fun DetailNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = PostDetail
    ) {
        composable("${PostDetail}/{postId}") { backStackEntry ->
            val postId = backStackEntry.arguments?.getString("postId")
            PostDetailScreen(postId = postId ?: "", onBack = { navController.popBackStack() })
        }
    }
}
