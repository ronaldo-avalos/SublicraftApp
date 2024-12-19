package com.coopertech.sublicraft.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coopertech.sublicraft.R

@Composable
fun ImagesGridComponent(
    images: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(if (images.size < 3) images.size else 3), // 3 columnas
        modifier = modifier.height(200.dp),
        userScrollEnabled = false
    ) {
        items(images.size) { index ->
            Box(modifier = modifier.aspectRatio(1f)
            ) {
                Image(
                    painter = images[index],
                    contentDescription = "Image $index",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview
@Composable
fun PostCardGridPreview() {
    ImagesGridComponent(
        images = listOf(
            painterResource(id = R.drawable.plantillanavidad1),
            painterResource(id = R.drawable.plantillanavidad2),

        )
    )
}
