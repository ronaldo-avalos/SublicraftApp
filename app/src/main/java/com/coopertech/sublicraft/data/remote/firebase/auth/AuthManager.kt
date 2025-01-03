package com.coopertech.sublicraft.data.remote.firebase.auth

import android.content.Context
import com.coopertech.sublicraft.data.remote.firebase.FirebaseAuthService
import com.coopertech.sublicraft.ui.common.UiState
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import kotlinx.coroutines.tasks.await


class AuthManager(private  val context: Context): FirebaseAuthService {
    private val auth: FirebaseAuth by lazy { Firebase.auth }

    override suspend fun signInAnonymously(): UiState<FirebaseUser> {
        return try {
            val result = auth.signInAnonymously().await()
            UiState.Success(result.user ?: throw Exception("Error al iniciar sesión"))
        } catch(e: Exception) {
            UiState.Error(e.message ?: "Error al iniciar sesión")
        }
    }



    override suspend fun createUserWithEmailAndPassword(email: String, password: String): UiState<FirebaseUser?> {
        return try {
            val authResult = auth.createUserWithEmailAndPassword(email, password).await()
            UiState.Success(authResult.user ?: throw Exception("Error al iniciar sesión"))
        } catch(e: Exception) {
            UiState.Error(e.message ?: "Error al crear el usuario")
        }
    }

    override suspend fun signInWithEmailAndPassword(email: String, password: String): UiState<FirebaseUser?> {
        return try {
            val authResult = auth.signInWithEmailAndPassword(email, password).await()
            UiState.Success(authResult.user ?: throw Exception("Error al iniciar sesión"))
        } catch(e: Exception) {
            UiState.Error(e.message ?: "Error al iniciar sesión")
        }
    }

    override suspend fun resetPassword(email: String): UiState<Unit> {
        return try {
            auth.sendPasswordResetEmail(email).await()
            UiState.Success(Unit)
        } catch(e: Exception) {
            UiState.Error(e.message ?: "Error al restablecer la contraseña")
        }
    }

    override fun signOut() {
        auth.signOut()
        //signInClient.signOut()
    }

    override fun getCurrentUser(): FirebaseUser? {
        return auth.currentUser
    }


}