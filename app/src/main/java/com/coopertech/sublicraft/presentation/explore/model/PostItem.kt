package com.coopertech.sublicraft.presentation.explore.model

import androidx.compose.ui.graphics.painter.Painter


data class PostItem(
    val id : String,
    val images: List<Painter>,
    val title: String,
    val userName: String = "@SubliPrintApp"
)
