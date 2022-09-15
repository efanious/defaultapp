package com.example.defaultapp.repository

import com.example.defaultapp.data.dto.UserItemDto
import com.example.defaultapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    suspend fun getUsers(): Flow<Resource<List<UserItemDto>>>
}