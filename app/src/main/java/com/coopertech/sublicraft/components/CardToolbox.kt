package com.coopertech.sublicraft.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coopertech.sublicraft.R


data class CardToolboxData(
    val title: String,
    val iconResource: Int
)

@Composable
fun CardToolbox(
    modifier: Modifier = Modifier,
    title: String,
    iconResource: Int
) {
    Card(
        modifier = modifier
            .size(140.dp) // Tamaño fijo para una mejor consistencia visual
             // Esquinas redondeadas
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp), // Espaciado interno
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = iconResource),
                contentDescription = null,
                modifier = Modifier.size(54.dp) // Tamaño ajustado del ícono
            )
            Spacer(modifier = Modifier.height(8.dp)) // Separación entre ícono y texto
            Text(
                text = title,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 12.sp // Ajuste del tamaño del texto
                ),
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}


@Preview
@Composable
fun CardPreview() {
    CardToolbox(
        modifier = Modifier.padding(16.dp),
        title = "Imprimir hoja de prueba",
        iconResource = R.drawable.ic_print)
}