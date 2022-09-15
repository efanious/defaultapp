package com.example.defaultapp.data

import com.example.defaultapp.data.dto.UserItemDto
import retrofit2.http.GET

interface UsersApi {

    @GET("/users")
    suspend fun getUsers(): List<UserItemDto>
}