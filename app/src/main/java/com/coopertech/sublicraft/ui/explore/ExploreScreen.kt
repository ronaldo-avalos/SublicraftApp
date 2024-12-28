package com.coopertech.sublicraft.ui.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coopertech.sublicraft.R
import com.coopertech.sublicraft.ui.components.ProductItem
import com.coopertech.sublicraft.ui.explore.model.PostItem

@Composable
fun ExploreScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Any?) -> Unit,
    addPostButtonTapped: () -> Unit,
    ) {
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

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                          addPostButtonTapped()
                },
                content = {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null )
                }) 
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            modifier = Modifier.padding(paddingValues),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(10) { index ->
                ProductItem(
                    imageUrl = R.drawable.plantillanavidad4, // Imagen de prueba
                    title = "Plantilla de envoltura $index",
                    rating = 4.5,
                    price = "$73.40 MXN",
                    discountPrice = "$147.02 MXN"
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ExploreScreenPreview() {
    ExploreScreen(navigateToDetail = {}) {
        
    }
}