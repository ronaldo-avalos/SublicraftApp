package com.coopertech.sublicraft.data.remote.firebase

import com.coopertech.sublicraft.ui.common.UiState
import com.google.firebase.auth.FirebaseUser

interface FirebaseAuthService {
    //Auth
    suspend fun signInAnonymously(): UiState<FirebaseUser>
    suspend fun createUserWithEmailAndPassword(email: String, password: String): UiState<FirebaseUser?>
    suspend fun signInWithEmailAndPassword(email: String, password: String): UiState<FirebaseUser?>
    suspend fun resetPassword(email: String): UiState<Unit>
    fun signOut()
    fun getCurrentUser(): FirebaseUser?
}