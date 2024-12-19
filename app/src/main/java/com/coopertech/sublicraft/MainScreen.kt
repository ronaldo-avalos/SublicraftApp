package com.coopertech.sublicraft

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coopertech.sublicraft.presentation.FavoritesScreen
import com.coopertech.sublicraft.presentation.PrintHome
import com.coopertech.sublicraft.presentation.explore.ExploreScreen

data class NavItem(
    val label: String,
    val icon: Int
)

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navItemList = listOf(
        NavItem("Print", R.drawable.round_print_24),
        NavItem("Explorar", R.drawable.ic_explore),
        NavItem("Favoritos", R.drawable.ic_favorites)
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    Scaffold(modifier = modifier,
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        icon = {
                            Icon(
                                painter = painterResource(id = navItem.icon),
                                contentDescription = navItem.label
                            )
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(modifier = modifier.padding(innerPadding), selectedIndex)
    }

}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int) {
    when(selectedIndex) {
        0 -> PrintHome(modifier.padding(bottom = 0.dp))
        1 -> ExploreScreen(modifier.padding(bottom = 0.dp))
        2 -> FavoritesScreen(modifier.padding(bottom = 0.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainPreview() {
    MainScreen()
}
