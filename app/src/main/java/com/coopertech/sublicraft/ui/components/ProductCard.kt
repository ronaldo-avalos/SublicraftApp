package com.coopertech.sublicraft.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import com.coopertech.sublicraft.ui.theme.SublicraftTheme


@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    image: String,
    title: String,
    rating: String,
    price: String,
    category: String,
    addToCart: () -> Unit,
    itemTapped: () -> Unit,
) {
    val ratingState by remember { mutableFloatStateOf(rating.toFloat()) }

    Column(
        modifier = modifier
            .clickable { itemTapped() }
            .padding(8.dp) // Opcional: Espaciado interno de cada tarjeta
//            .fillMaxSize(), // Asegura que ocupe todo el espacio de la celda
//        horizontalAlignment = Alignment.Start
    ) {
        AsyncImage(
            model = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1 / 1f)
                .clip(RoundedCornerShape(4.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            fontSize = 12.sp,
            text = category,
            color = MaterialTheme.colorScheme.outline
        )
        Text(
            text = title,
            maxLines = 2,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                fontSize = 12.sp,
                text = "$rating/5",
                color = MaterialTheme.colorScheme.outline
            )
            Spacer(modifier = Modifier.width(4.dp))
            RatingBar(
                modifier = Modifier.offset(y = (-2).dp),
                rating = ratingState,
            )
        }
    }
}

@Composable
fun RatingBar(
    rating: Float,
    modifier: Modifier = Modifier,
    starCount: Int = 5,
    filledStarColor: Color = Color("#FFB000".toColorInt()),
    unfilledStarColor: Color = MaterialTheme.colorScheme.outline,
) {
    Row(modifier = modifier) {
        for (i in 1..starCount) {
            val starFraction = rating - i + 1
            val iconTint = when {
                starFraction >= 1 -> filledStarColor
                else -> unfilledStarColor
            }
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = iconTint,
                modifier = Modifier
                    .size(15.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductCardPreview2() {
    SublicraftTheme {
        ProductCard(
            image = "https://cdn.rri.co.id/berita/1/images/1689391542821-images_(22)/1689391542821-images_(22).jpeg",
            title = "Plantillas para el día de las madres",
            rating = "3.5",
            price = "23.22",
            category = "Makanan",
            addToCart = {},
            itemTapped = {

            }
        )
    }
}