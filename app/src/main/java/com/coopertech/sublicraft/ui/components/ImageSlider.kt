package com.coopertech.sublicraft.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coopertech.sublicraft.R
@Composable
fun ImageSlider(images: List<Int>, modifier: Modifier = Modifier) {
    var currentPage by remember { mutableIntStateOf(0) }
    val totalDots = 5// Número fijo de puntos
    val imageCount = images.size
    val pagerState = rememberPagerState(
        pageCount = { Int.MAX_VALUE }
    )

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image slider
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        ) { page ->
            val actualIndex = page % imageCount // Calcula el índice válido de la imagen
            Image(
                painter = painterResource(id = images[actualIndex]),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Update the current page as the user scrolls
        LaunchedEffect(pagerState) {
            snapshotFlow { pagerState.currentPage }.collect { page ->
                currentPage = page
            }
        }

        // Dots indicator
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            val currentDotIndex = currentPage % totalDots // Control de 6 puntos
            repeat(totalDots) { index ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(if (index == currentDotIndex) 8.dp else 6.dp)
                        .clip(CircleShape)
                        .background(
                            if (index == currentDotIndex) Color.Black else Color.LightGray.copy(alpha = 0.5f)
                        )
                )
            }
        }
    }
}

@Preview
@Composable
fun ImageSliderPreview() {
    val  images = listOf<Int>(
        R.drawable.plantillanavidad1,
        R.drawable.plantillanavidad2,
        R.drawable.plantillanavidad3,
        R.drawable.plantillanavidad4,
        R.drawable.plantillanavidad6,
    )
    ImageSlider(images = images, modifier = Modifier.fillMaxSize())
}