package com.coopertech.sublicraft.ui.explore

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.coopertech.sublicraft.ui.components.ImagesGridComponent
import com.coopertech.sublicraft.ui.explore.model.SublimationPost


@Composable
fun CreatePostScreen(
    onPostSubmit: (SublimationPost) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var tags by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    val imageList = remember { mutableStateListOf<Uri>() }
    var fileLink by remember { mutableStateOf("") }
    val maxImages = 30

    Scaffold(
        modifier = Modifier
            .fillMaxSize() ,
    ) { padding ->
        Row(
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .padding(16.dp)
        ){
            val imageUrls = listOf(
                "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/471768540_122196719852162298_560546721802699623_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=127cfc&_nc_eui2=AeEgOSHkltcnBSWLS-FpW9PIhl0HXj17YQeGXQdePXthB1Ldt3dpU8n1Q1N3ThpdQ5AWYbyS0CrCCeTKBiAAza_i&_nc_ohc=er9yCs-R06oQ7kNvgGkydua&_nc_oc=Adh3pGc4MBV_IQKJPNXAXGduK6vwZJ9n5koVC2vOX1U8Nyneq61Vc88AtTukaC6uN62zXRq7obSJq94uLM3Mrgkf&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=Ah6eQHzfIzkUacrFxJgjsNg&oh=00_AYDddKX1Mb61x36zm1z6tmjOo-854rqhpGnAEyAQyAX0Uw&oe=67765A42", // Reemplaza con URLs o recursos reales
                "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/471847933_122196719882162298_1372966082940884357_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=127cfc&_nc_eui2=AeEEBuX8lM8JWo6nDSrZZ6HQBoHZa6qvN80Ggdlrqq83zVPQyGFQMtacnB8uS2rrv58c0zq44Qk2AyDbuZ4Fs7lG&_nc_ohc=j0K14Zy1CUcQ7kNvgGhlrGO&_nc_oc=Adgb0xpz6PJKKw1xfX5znQURFQSiCxYgULKDrkTSm8Hj_AvqQICdeYV4xuacgKNiSLO3QWPg3M1reovSCXXqGk-8&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=ALMBxOuvAy4IvVwcaST7uN4&oh=00_AYDVZyA7HFlEWRzo9XuWeoHk8j_pmzAB6NGMsLxHv2iEdw&oe=67763A6E",
                "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/471762883_122196719912162298_227721876196023186_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=127cfc&_nc_eui2=AeFS8EzqlLu34ifuX2tNijAjjSW5B6GCqACNJbkHoYKoANviaqkb--DpNs-0o5-pD9ivaM8XyMQFfFsUgagHuFy7&_nc_ohc=jME3gxXhp6cQ7kNvgGAZVSq&_nc_oc=Adgc5ENMi9qSr1GgiUxjwIAT1ju6FfykzPbMlUoJlPL8F5MsIN3R6UcaCSQOdP9OwYT5RpcBu_ISDN6IAZDBgRAc&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=A4mV3JTsnIqzW40ezd7mKFR&oh=00_AYAzCKOI98Vuw_I3b9XElW9-A_n4YIq2FiNC9J0qOcsZSQ&oe=6776561F"
            )

            StackedImages(
                imageUrls = imageUrls,
                imageSize = 120.dp,
                overlapOffset = 14.dp
            )
        }

     //   ImageUploader(modifier = Modifier.padding(padding))

//        Button(
//            onClick = {
//                val post = SublimationPost(
//                    title = title,
//                    description = description,
//                    tags = tags.split(",").map { it.trim() },
//                    category = category,
//                    images = imageList.map { it.toString() },
//                    fileLink = fileLink,
//                    createdAt = System.currentTimeMillis(),
//                    userId = "userID"
//                )
//                onPostSubmit(post)
//            },
//        ) {
//            Text("Publicar")
//        }
    }
}

@Composable
fun StackedImages(
    imageUrls: List<String>, // Lista de URLs o recursos locales para las imágenes
    imageSize: Dp = 120.dp, // Tamaño de las imágenes
    overlapOffset: Dp = 2.dp, // Separación entre imágenes
    cornerRadius: Dp = 8.dp // Radio de los bordes redondeados
) {
    Box(modifier = Modifier.size(imageSize)) {
        imageUrls.forEachIndexed { index, imageUrl ->
            Image(
                painter = rememberAsyncImagePainter(model = imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(imageSize)
                    .graphicsLayer {
//                        translationX = (index * overlapOffset.value) // Desplazamiento horizontal
                        translationY = (index * overlapOffset.value) // Desplazamiento vertical
                    }
                    .clip(RoundedCornerShape(cornerRadius)) // Aplica bordes redondeados
                    .border(2.dp, color = Color.White, shape = RoundedCornerShape(cornerRadius)) // Borde con el mismo radio
            )
        }
    }
}



@Composable
fun ImageUploader(modifier: Modifier = Modifier) {
    var selectedImages by remember { mutableStateOf<List<Uri>>(emptyList()) }
    val maxImages = 30

    val multiplePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract =  ActivityResultContracts.PickMultipleVisualMedia(),
        onResult = { uris ->  selectedImages = uris}
        )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {

        // Botón para abrir la galería
        Button(
            onClick = {
                multiplePhotoPickerLauncher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
//                galleryLauncher.launch("image/*")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Abrir Galería (${selectedImages.size}/$maxImages)")
        }

        Spacer(modifier = Modifier.height(16.dp))
         AnimatedVisibility(selectedImages.isNotEmpty()) {
             ImagesGridComponent(
                 isScrollEnable = true,
                 images = selectedImages,
                 modifier = Modifier.fillMaxSize(),
                 spaceBetween = 2.dp
             )
//            LazyVerticalGrid(
//                columns = GridCells.Fixed(if (selectedImages.size < 3) selectedImages.size else 4),
//                modifier = Modifier.fillMaxSize(),
//                contentPadding = PaddingValu6es(2.dp),
//                verticalArrangement = Arrangement.spacedBy(2.dp),
//                horizontalArrangement = Arrangement.spacedBy(2.dp)
//            ) {
//                items(selectedImages) { uri ->
//                    ImageItem(uri = uri)
//                }
//            }
        }
    }
}

@Preview
@Composable
fun AddPostPreview() {
    CreatePostScreen(){

    }
}