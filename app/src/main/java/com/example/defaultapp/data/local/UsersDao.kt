package com.example.defaultapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.defaultapp.models.UserItem
import kotlinx.coroutines.flow.Flow


@Dao
interface UsersDao {

    @Query("SELECT * FROM app_users")
    suspend fun getAllUsers(): List<UserItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<UserItem>)

    @Query("DELETE FROM app_users")
    suspend fun deleteAllUsers()
}