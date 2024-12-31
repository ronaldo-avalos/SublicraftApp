package com.coopertech.sublicraft.ui.screen.explore

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coopertech.sublicraft.ui.components.ProductCard

@Composable
fun ExploreScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Any?) -> Unit,
    addPostButtonTapped: () -> Unit,
) {

    val imagesList  = listOf(
        "https://mottaconsultores.com/wp-content/uploads/2021/04/2_Plantillas-estampar-tazas-frases-mensajes-dia-de-las-madres-disenos-sublimar-mug-somos-motta-min.jpg",
        "https://subliplantillas.com/wp-content/uploads/2024/11/plantillas-para-tazas-de-moana-2-768x768.jpg",
        "https://subliplantillas.com/wp-content/uploads/2024/11/plantillas-para-tazas-navidad-magica-768x768.jpg",
        "https://subliplantillas.com/wp-content/uploads/2024/11/plantillas-para-tazas-dulce-navidad-768x768.jpg",
        "https://subliplantillas.com/wp-content/uploads/2024/07/plantillas-para-tazas-camisetas-equipos-espanoles-768x768.jpg",
        "https://subliplantillas.com/wp-content/uploads/2024/07/plantillas-para-tazas-de-one-piece-768x768.jpg",
        "https://subliplantillas.com/wp-content/uploads/2024/06/plantillas-para-tazas-de-intensamente-2-768x768.jpg",
        "https://subliplantillas.com/wp-content/uploads/2024/04/plantillas-para-camisetas-graduados-768x768.jpg",
        "https://subliplantillas.com/wp-content/uploads/2024/03/plantillas-para-tazas-frases-mal-humor-768x768.jpg",
        "https://subliplantillas.com/wp-content/uploads/2023/12/plantillas-para-tazas-navidad-colores-pastel-768x768.jpg",
        "https://subliplantillas.com/wp-content/uploads/2023/11/plantillas-para-tazas-de-flork-feliz-navidad-768x768.jpg",
        "https://subliplantillas.com/wp-content/uploads/2023/10/plantillas-para-tazas-calendario-navidad-2024-768x768.jpg",
        "https://subliplantillas.com/wp-content/uploads/2020/05/plantillas-para-tazas-de-superman-600x600.jpg",
        "https://subliplantillas.com/wp-content/uploads/2020/05/plantillas-para-tazas-de-batman-600x600.jpg",
        "https://subliplantillas.com/wp-content/uploads/2020/05/plantillas-para-tazas-de-avengers-600x600.jpg",
        "https://subliplantillas.com/wp-content/uploads/2020/04/plantillas-para-tazas-de-cumpleaños-600x600.jpg",
        "https://subliplantillas.com/wp-content/uploads/2020/03/plantillas-para-tazas-de-spiderman-600x600.jpg",
        "https://www.aimariec.com/wp-content/webpc-passthru.php?src=https://www.aimariec.com/wp-content/uploads/2021/02/plantillas-para-sublimar-tazas.jpg&nocache=1",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTypLjDRaqjDgbSRQUvPeXekJGK0neqPh-kvw&s",
        "https://ml.plantillasparasublimar.com/wp-content/uploads/edd/2024/04/plantillasparasublimar.com_9-25.jpg"
    )

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
            items(imagesList.size) { index ->
                ProductCard(
                    image = imagesList[index],
                    title = "Plantillas dia de la madre GRATIS",
                    rating = "3.5",
                    price = "23.22",
                    category = "Sublicraft",
                    addToCart = {},
                    itemTapped = {
                        navigateToDetail(imagesList[index])
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