package com.example.defaultapp.data.remote.dto

import com.example.defaultapp.models.UserItem

data class UserItemDto(
    val id: Int?,
    val name: String?,
    val username: String?,
    val email: String?
) {
    fun toUserItem(): UserItem {
        return UserItem(id, name, username, email)
    }
}

//TODO Add more fields