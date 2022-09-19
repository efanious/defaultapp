package com.example.defaultapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.defaultapp.models.UserItem


@Database(entities = [UserItem::class], version = 1)
abstract class UsersDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDao
}