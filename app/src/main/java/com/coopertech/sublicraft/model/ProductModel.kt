package com.coopertech.sublicraft.model

import java.util.UUID


data class ProductModel(
    val id: String = UUID.randomUUID().toString(), // Identificador único
    val title: String,
    val description: String,
    val thumbnail: String,
    val tags: List<String>, // Lista de etiquetas
    val category: String,
    val images: List<String>, // Lista de URLs de las imágenes subidas
    val fileLink: String?, // Enlace o archivo comprimido opcional
    val createdAt: Long = System.currentTimeMillis(), // Timestamp para ordenar los posts
    val userId: String // Relación con el usuario que crea el post
)
