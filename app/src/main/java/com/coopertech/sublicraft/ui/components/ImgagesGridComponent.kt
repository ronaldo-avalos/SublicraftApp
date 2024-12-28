package com.coopertech.sublicraft.ui.components

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun ImagesGridComponent(
    images: List<Uri>,
    modifier: Modifier = Modifier,
    spaceBetween : Dp = 0.dp,
    isScrollEnable : Boolean = false
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(if (images.size < 3) images.size else 3), // 3 columnas
        modifier = modifier.height(200.dp),
        userScrollEnabled = isScrollEnable,
        verticalArrangement = Arrangement.spacedBy(spaceBetween),
        horizontalArrangement = Arrangement.spacedBy(spaceBetween)
    ) {
        items(images) { img ->
            Box(modifier = modifier.aspectRatio(1f)
            ) {
                ImageItem(uri = img )
            }
        }
    }
}

@Composable
fun ImageItem(uri: Uri) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(uri)
            .build()
    )

    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

@Preview
@Composable
fun PostCardGridPreview() {

}
