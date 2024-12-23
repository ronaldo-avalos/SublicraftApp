package com.coopertech.sublicraft.ui.explore

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coopertech.sublicraft.ui.explore.model.SublimationPost


@Composable
fun CreatePostScreen(
    onPostCreated: (SublimationPost) -> Unit
) {
    val imageList = remember { mutableStateListOf<Uri>() }
    val tags = remember { mutableStateListOf<String>() }
    val categories = listOf("Navideñas", "Amor", "Cumpleaños", "Anime")
    val selectedCategory = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val fileUrl = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Añadir imágenes
        Text(text = "Subir imágenes (máx 30)")
        ImagePicker(
            imageList = imageList,
            maxImages = 30
        )

        // Añadir etiquetas
        Text(text = "Añadir etiquetas")
        TagInput(tags = tags)

        // Selección de categoría
        Text(text = "Seleccionar categoría")
//        DropdownMenu(
//            categories = categories,
//            selectedCategory = selectedCategory
//        )

        // Campo de descripción
        OutlinedTextField(
            value = description.value,
            onValueChange = { description.value = it },
            label = { Text("Descripción del post") },
            modifier = Modifier.fillMaxWidth()
        )

        // Subir archivo o enlace
        OutlinedTextField(
            value = fileUrl.value,
            onValueChange = { fileUrl.value = it },
            label = { Text("Enlace o URL del archivo (WingRar/Zip)") },
            modifier = Modifier.fillMaxWidth()
        )

        // Botón para crear el post
        Button(
            onClick = {
                val newPost = SublimationPost(
                    images = imageList.map { it.toString() },
                    tags = tags.toList(),
                    category = selectedCategory.value,
                    description = description.value,
                    fileUrl = fileUrl.value.ifBlank { null }
                )
                onPostCreated(newPost)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Crear Post")
        }
    }
}

@Composable
fun ImagePicker(imageList: MutableList<Uri>, maxImages: Int) {
    // Implementación simplificada para subir imágenes
    Button(onClick = {
        if (imageList.size < maxImages) {
            // Aquí iría la lógica para seleccionar imágenes usando un picker
        }
    }) {
        Text("Seleccionar imágenes (${imageList.size}/$maxImages)")
    }
}

@Composable
fun TagInput(tags: MutableList<String>) {
    val newTag = remember { mutableStateOf("") }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = newTag.value,
            onValueChange = { newTag.value = it },
            label = { Text("Nueva etiqueta") },
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = {
            if (newTag.value.isNotBlank()) {
                tags.add(newTag.value.trim())
                newTag.value = ""
            }
        }) {
            Text("Añadir")
        }
    }
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(top = 8.dp)
    ) {
//        items(tags) { tag ->
//            Chip(label = tag) // Implementar un Chip personalizado o usar Material3
//        }
    }
}

//@Composable
//fun DropdownMenu(categories: List<String>, selectedCategory: @Composable () -> Unit) {
//    var expanded by remember { mutableStateOf(false) }
//    Box {
//        OutlinedTextField(
//            value = selectedCategory,
//            onValueChange = {},
//            text = "Categoría",
//            readOnly = true,
//            modifier = Modifier.fillMaxWidth(),
//            trailingIcon = {
////                IconButton(onClick = { expanded = true }) {
////                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
////                }
//            }
//        )
//        DropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false }
//        ) {
//            categories.forEach { category ->
//                DropdownMenuItem(
//                    onClick = {
//                        selectedCategory.value = category
//                        expanded = false
//                    }
//                ) {
//                    Text(text = category)
//                }
//            }
//        }
//    }
//}



@Preview
@Composable
fun AddPostPreview() {
    CreatePostScreen(){

    }
}