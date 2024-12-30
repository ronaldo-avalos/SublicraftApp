package com.coopertech.sublicraft.ui.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coopertech.sublicraft.ui.components.ProductCard2
import com.coopertech.sublicraft.ui.explore.model.PostItem

@Composable
fun ExploreScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Any?) -> Unit,
    addPostButtonTapped: () -> Unit,
) {
    val favoriteState = remember { mutableStateMapOf<PostItem, Boolean>() }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    addPostButtonTapped()
                },
                content = {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                })
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(12.dp), // Espaciado externo
            horizontalArrangement = Arrangement.spacedBy(4.dp), // Espaciado horizontal entre celdas
            verticalArrangement = Arrangement.spacedBy(4.dp) // Espaciado vertical entre celdas
        ) {
            items(10) { index ->
                ProductCard2(
                    image = "https://mottaconsultores.com/wp-content/uploads/2021/04/2_Plantillas-estampar-tazas-frases-mensajes-dia-de-las-madres-disenos-sublimar-mug-somos-motta-min.jpg",
                    title = "Plantillas dia de la madre GRATIS",
                    rating = "3.5",
                    price = "23.22",
                    category = "Sublicraft",
                    addToCart = {},
                    itemTapped = {
                        navigateToDetail("")
                    }
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .aspectRatio(1f) // Hace que cada celda sea cuadrada
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