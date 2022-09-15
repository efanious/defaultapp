package com.example.defaultapp.data

import com.example.defaultapp.data.dto.UsersResponseDto
import retrofit2.http.GET

interface UsersApi {

    @GET("/users")
    suspend fun getUsers(): UsersResponseDto
}