package com.coopertech.sublicraft.presentation.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coopertech.sublicraft.R
import com.coopertech.sublicraft.components.PostCardComponent
import com.coopertech.sublicraft.presentation.explore.model.PostItem

@Composable
fun ExploreScreen(modifier: Modifier = Modifier, navigateToDetail: (Any?) -> Unit) {
    val postsList = listOf(
        PostItem(
            id = "213123",
            images = listOf(
                painterResource(id = R.drawable.plantillanavidad1),
                painterResource(id = R.drawable.plantillanavidad2),
                painterResource(id = R.drawable.plantillanavidad3),
                painterResource(id = R.drawable.plantillanavidad4),
                painterResource(id = R.drawable.plantillanavidad6),
                painterResource(id = R.drawable.plantillanavidad1),
            ),
            title = "Pack de plantillas navideñas"
        ),
        PostItem(
            id = "213123",
            images = listOf(
                painterResource(id = R.drawable.plantillanavidad1),
                painterResource(id = R.drawable.plantillanavidad2),
                painterResource(id = R.drawable.plantillanavidad1),
            ),
            title = "Pack de plantillas para el día de muertos"
        ),
        PostItem(
            id = "213123",
            images = listOf(
                painterResource(id = R.drawable.plantillanavidad1),
                painterResource(id = R.drawable.plantillanavidad2),
                painterResource(id = R.drawable.plantillanavidad3),
                painterResource(id = R.drawable.plantillanavidad4),
                painterResource(id = R.drawable.plantillanavidad6),
                painterResource(id = R.drawable.plantillanavidad1),
            ),
            title = "Pack de plantillas para el día de muertos"
        ),
        PostItem(
            id = "213123",
            images = listOf(
                painterResource(id = R.drawable.plantillanavidad1),
                painterResource(id = R.drawable.plantillanavidad2),
                painterResource(id = R.drawable.plantillanavidad3),
                painterResource(id = R.drawable.plantillanavidad4),
                painterResource(id = R.drawable.plantillanavidad6),
                painterResource(id = R.drawable.plantillanavidad1),
            ),
            title = "Pack de plantillas para el día de muertos"
        ),
        PostItem(
            id = "213123",
            images = listOf(
                painterResource(id = R.drawable.plantillanavidad1),
                painterResource(id = R.drawable.plantillanavidad2),
                painterResource(id = R.drawable.plantillanavidad3),
                painterResource(id = R.drawable.plantillanavidad4),
                painterResource(id = R.drawable.plantillanavidad6),
                painterResource(id = R.drawable.plantillanavidad1),
            ),
            title = "Pack de plantillas para el día de muertos"
        ),  PostItem(
            id = "213123",
            images = listOf(
                painterResource(id = R.drawable.plantillanavidad1),
                painterResource(id = R.drawable.plantillanavidad2),
                painterResource(id = R.drawable.plantillanavidad3),
                painterResource(id = R.drawable.plantillanavidad4),
                painterResource(id = R.drawable.plantillanavidad6),
                painterResource(id = R.drawable.plantillanavidad1),
            ),
            title = "Pack de plantillas para el día de muertos"
        ),
        PostItem(
            id = "213123",
            images = listOf(
                painterResource(id = R.drawable.plantillanavidad1),
                painterResource(id = R.drawable.plantillanavidad2),
                painterResource(id = R.drawable.plantillanavidad3),
                painterResource(id = R.drawable.plantillanavidad4),
                painterResource(id = R.drawable.plantillanavidad6),
                painterResource(id = R.drawable.plantillanavidad1),
            ),
            title = "Pack de plantillas para el día de muertos"
        ),
        PostItem(
            id = "213123",
            images = listOf(
                painterResource(id = R.drawable.plantillanavidad1),
                painterResource(id = R.drawable.plantillanavidad2),
                painterResource(id = R.drawable.plantillanavidad4),
                painterResource(id = R.drawable.plantillanavidad6),
                painterResource(id = R.drawable.plantillanavidad1),
            ),
            title = "Pack de plantillas para el día de muertos"
        )


    )
    val favoriteState = remember { mutableStateMapOf<PostItem, Boolean>() }

    Scaffold { paddingValues ->
        LazyColumn(
            modifier = modifier.padding(paddingValues = paddingValues),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            this.items(postsList) { post ->
                PostCardComponent(
                    postItem = post,
                    isFavorite = favoriteState[post] ?: false,
                    onFavoriteChanged = { item, isFav ->
                        favoriteState[item] = isFav // Actualizar el estado
                    },
                    onPostTapped = {
                        navigateToDetail(post)
                    }
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ExploreScreenPreview() {
    ExploreScreen {}
}