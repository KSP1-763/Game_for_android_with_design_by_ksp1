package com.example.network.api

import com.example.network.client.KtorClient
import com.example.network.dto.LoginRequest
import com.example.network.dto.LoginResponse
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class AuthApi(private val client: KtorClient) {
    suspend fun login(request: LoginRequest): LoginResponse{
        return client.client.post(client.url("auth/login")){
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }
}