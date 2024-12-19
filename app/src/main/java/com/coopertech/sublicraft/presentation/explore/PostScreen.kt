package com.coopertech.sublicraft.presentation.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.coopertech.sublicraft.components.ImagesGridComponent
import com.coopertech.sublicraft.presentation.explore.model.PostItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostDetailScreen(postItem: PostItem) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { /* Acción de navegación hacia atrás */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                        )
                    }
                },
               colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                )
            )
        },
        containerColor = Color(0xFFF6F6F6)
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)) {
            // Encabezado con imágenes y texto
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                ImagesGridComponent(
                    images = postItem.images,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black),
                                startY = 100f
                            )
                        )
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                ) {
                    Text(
                        text = postItem.title,
                        style = TextStyle(color = Color.White, fontSize = 20.sp)
                    )
                    Text(
                        text = "@SubliPrintApp",
                        style = TextStyle(color = Color.LightGray, fontSize = 14.sp)
                    )
                }
            }

            // Lista debajo del encabezado
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(10) { index -> // Lista simulada con 10 elementos
                    ListItemComponent()
                }
            }
        }
    }
}


@Composable
fun ListItemComponent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(64.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "List item",
                style = TextStyle(fontSize = 16.sp, color = Color.Black)
            )
            Text(
                text = "Category • $$ • 1.2 miles away",
                style = TextStyle(fontSize = 14.sp, color = Color.Gray)
            )
            Text(
                text = "Supporting line text lorem ipsum...",
                style = TextStyle(fontSize = 12.sp, color = Color.Gray)
            )
        }
        IconButton(onClick = {

        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_download),
                contentDescription = "Download",
                tint = Color.Gray
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PostScreenPreview(){
    PostDetailScreen(
        PostItem(
            images = listOf(
                painterResource(id = R.drawable.plantillanavidad1),
                painterResource(id = R.drawable.plantillanavidad2),
                painterResource(id = R.drawable.plantillanavidad4),
                painterResource(id = R.drawable.plantillanavidad6),
                painterResource(id = R.drawable.plantillanavidad1),
            ),
            title = "Pack de plantillas para el día de muertos"
        ),
    )
}