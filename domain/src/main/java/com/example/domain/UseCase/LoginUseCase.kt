package com.example.domain.UseCase

import com.example.domain.Model.User
import com.example.domain.Repository.AuthRepository

class LoginUseCase (private val repository: AuthRepository){
    suspend operator fun invoke(email: String,password: String): Result<User>{
        if(email.isBlank() || password.isBlank()){
            return Result.failure(Exception("Login или пароль не могут быть пустыми"))
        }
        return repository.login(email,password)
    }
}