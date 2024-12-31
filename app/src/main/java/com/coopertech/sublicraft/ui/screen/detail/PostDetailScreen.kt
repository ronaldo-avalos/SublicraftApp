package com.coopertech.sublicraft.ui.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coopertech.sublicraft.R
import com.coopertech.sublicraft.ui.components.ImageSlider
import com.coopertech.sublicraft.model.ProductModel

@Composable
fun PostDetailScreen(postID: String, onBack: () -> Unit) {
    //Get post for ID

    val postItem = ProductModel(
        title = "Superhéroes para Tazas",
        description = "Explora plantillas de tus superhéroes favoritos como Superman, Batman y Avengers.",
        thumbnail = "https://subliplantillas.com/wp-content/uploads/2020/05/plantillas-para-tazas-de-avengers-600x600.jpg",
        tags = listOf("superman", "batman", "avengers", "tazas"),
        category = "Cómics",
        images = listOf(
            "https://subliplantillas.com/wp-content/uploads/2020/05/plantillas-para-tazas-de-superman-600x600.jpg",
            "https://subliplantillas.com/wp-content/uploads/2020/05/plantillas-para-tazas-de-batman-600x600.jpg",
            "https://subliplantillas.com/wp-content/uploads/2020/05/plantillas-para-tazas-de-avengers-600x600.jpg"
        ),
        fileLink = "https://example.com/files/tazas_superheroes.zip",
        userId = "user_123"
    )

    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        // Acción de descarga
                        onDownload(postItem.fileLink)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Descargar", style = TextStyle(fontSize = 16.sp))
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
        ) {
            // Encabezado con imágenes y texto
            item {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    ImageSlider(images = postItem.images, modifier = Modifier.fillMaxSize())
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = postItem.title,
                        style = TextStyle(fontSize = 22.sp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = postItem.description,
                        style = TextStyle(color = Color.Gray, fontSize = 14.sp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    //  ListItemComponent()
                }
            }
        }
    }
}


fun onDownload(fileLink: String?) {
    fileLink?.let {
        // Inicia la descarga del archivo
        println("Iniciando descarga desde: $fileLink")
        // Aquí puedes implementar la lógica para descargar el archivo,
        // como usar DownloadManager o una librería como Retrofit.
    } ?: run {
        println("El enlace de descarga no está disponible")
    }
}


    @Composable
fun ListItemComponent(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(52.dp)
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
fun PostScreenPreview() {
    PostDetailScreen(postID = "1223") { }
}