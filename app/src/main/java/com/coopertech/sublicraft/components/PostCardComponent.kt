package com.coopertech.sublicraft.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coopertech.sublicraft.R
import com.coopertech.sublicraft.presentation.explore.model.PostItem


@Composable
fun PostCardComponent(
    isFavorite: Boolean,
    postItem: PostItem,
    onFavoriteChanged: (PostItem, Boolean) -> Unit,
    onPostTapped: (PostItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth().clickable { onPostTapped(postItem)
        },
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            ImagesGridComponent(
                images = postItem.images
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f,
                        )
                    )
            ) {
            }
            Text(
                modifier = Modifier
                    .padding(16.dp, bottom = 32.dp)
                    .align(Alignment.BottomStart),
                text = postItem.title, style = TextStyle(color = Color.White, fontSize = 18.sp)
            )
            Text(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomStart),
                text = postItem.userName, style = TextStyle(color = Color.LightGray, fontSize = 9.sp)
            )
            Icon(
                painter = painterResource(
                    id = if (isFavorite) R.drawable.baseline_favorite else R.drawable.baseline_favorite_border
                ),
                contentDescription = if (isFavorite) "Favorito" else "No favorito",
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
                    .clickable { onFavoriteChanged(postItem, !isFavorite) }, // Alternar favorito
                tint = if (isFavorite) Color.Red else Color.White
            )
        }
    }
}


@Preview
@Composable
fun PostCardPreview() {
    val item =  PostItem(
        id = "213123",
        images = listOf(
            painterResource(id = R.drawable.plantillanavidad1),
            painterResource(id = R.drawable.plantillanavidad2),
            painterResource(id = R.drawable.plantillanavidad3),
            painterResource(id = R.drawable.plantillanavidad4),
            painterResource(id = R.drawable.plantillanavidad6),
            painterResource(id = R.drawable.plantillanavidad1),
        ),
        title = "Pack de plantillas navideñas y esto es texto de prueba "
    )
    PostCardComponent(
        postItem = item,
        isFavorite =  false,
        onFavoriteChanged = { _, _ ->

        },
        onPostTapped = { }
    )
}
