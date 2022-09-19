package com.example.defaultapp.repository

import com.example.defaultapp.data.remote.dto.UserItemDto
import com.example.defaultapp.models.UserItem
import com.example.defaultapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    //suspend fun getUsers(): Flow<Resource<List<UserItemDto>>>
    suspend fun getUsers(): Flow<Resource<List<UserItem>>>
}