package com.coopertech.sublicraft.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coopertech.sublicraft.R
import com.coopertech.sublicraft.components.CardToolbox
import com.coopertech.sublicraft.components.CardToolboxData


@Composable
fun PrintHome(modifier: Modifier = Modifier) {
   ToolBox(modifier = modifier)
}

@Composable
fun ToolBox(modifier: Modifier) {
    val cardDataList = listOf(
        CardToolboxData("Imprimir hoja de prueba", R.drawable.ic_print),
        CardToolboxData("Tiempos y temperaturas", R.drawable.ic_times_list),
        CardToolboxData("Guías de sublimación", R.drawable.ic_guides),
        CardToolboxData("Cajas plantillas", R.drawable.ic_box),
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título
            Text(
                text = "Caja de herramientas",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            // LazyVerticalGrid para las tarjetas
            LazyVerticalGrid(
                columns = GridCells.Fixed(3), // Número de columnas
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                items(cardDataList.size) { index ->
                    val cardData = cardDataList[index]
                    CardToolbox(
                        title = cardData.title,
                        iconResource = cardData.iconResource
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun CardPreview() {
   PrintHome()
}

