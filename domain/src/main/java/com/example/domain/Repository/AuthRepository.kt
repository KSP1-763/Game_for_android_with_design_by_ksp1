package com.example.domain.Repository

import com.example.domain.Model.User

interface AuthRepository {
    suspend fun login(email: String,password: String): Result<User>
}