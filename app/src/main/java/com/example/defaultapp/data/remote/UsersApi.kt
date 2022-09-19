package com.example.defaultapp.data.remote

import com.example.defaultapp.data.remote.dto.UserItemDto
import retrofit2.http.GET

interface UsersApi {

    @GET("/users")
    suspend fun getUsers(): List<UserItemDto>
}