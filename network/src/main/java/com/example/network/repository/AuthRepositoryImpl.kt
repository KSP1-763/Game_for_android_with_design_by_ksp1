package com.example.network.repository

import com.example.domain.Model.User
import com.example.domain.Repository.AuthRepository
import com.example.network.api.AuthApi
import com.example.network.client.KtorClient
import com.example.network.dto.LoginRequest

class AuthRepositoryImpl(private val api: AuthApi): AuthRepository {
    override suspend fun login(email: String, password: String): Result<User> {
        return try{
            val response=api.login(LoginRequest(email,password))
            Result.success(User(
                id=response.userId,
                token = response.token,
                email=email
            ))
        }
        catch (e: Exception){
            Result.failure(e)
        }
    }
}