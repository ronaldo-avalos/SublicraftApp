package com.coopertech.sublicraft.data.remote.firebase

import android.content.Context
import com.google.firebase.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.storage

class FirebaseStorageManager(context: Context) {

    private val store = Firebase.storage
    private val storageRef = store.reference

   private val firebase = FirebaseStorage.getInstance().getReference()
//    override fun getAllProduct(limit: Int): List<ProductModel> {
//        TODO("Not yet implemented")
//    }

//    override fun uploadProduct(productModel: ProductModel): UiState<ProductModel> {

//
//        val postItem = ProductModel(
//            title = "Superhéroes para Tazas",
//            description = "Explora plantillas de tus superhéroes favoritos como Superman, Batman y Avengers.",
//            thumbnail = "https://subliplantillas.com/wp-content/uploads/2020/05/plantillas-para-tazas-de-avengers-600x600.jpg",
//            tags = listOf("superman", "batman", "avengers", "tazas"),
//            category = "Cómics",
//            images = listOf(
//                "https://subliplantillas.com/wp-content/uploads/2020/05/plantillas-para-tazas-de-superman-600x600.jpg",
//                "https://subliplantillas.com/wp-content/uploads/2020/05/plantillas-para-tazas-de-batman-600x600.jpg",
//                "https://subliplantillas.com/wp-content/uploads/2020/05/plantillas-para-tazas-de-avengers-600x600.jpg"
//            ),
//            fileLink = "https://example.com/files/tazas_superheroes.zip",
//            userId = "user_123"
//        )
//       return UiState.Success(postItem)
//    }
}