package com.coopertech.sublicraft.ui.explore.model



data class SublimationPost(
    val images: List<String>, // URLs de las imágenes subidas
    val tags: List<String>, // Lista de etiquetas
    val category: String, // Categoría seleccionada
    val description: String, // Descripción del post
    val fileUrl: String? = null, // URL del archivo subido
    val createdAt: Long = System.currentTimeMillis() // Timestamp del post
)
