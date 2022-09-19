package com.example.defaultapp.repository

import androidx.room.withTransaction
import com.example.defaultapp.data.local.UsersDatabase
import com.example.defaultapp.data.remote.UsersApi
import com.example.defaultapp.data.remote.dto.UserItemDto
import com.example.defaultapp.models.UserItem
import com.example.defaultapp.util.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class UsersRepositoryImpl @Inject constructor(
    private val usersApi: UsersApi,
    private val database: UsersDatabase
) :
    UsersRepository {

    private val usersDao = database.usersDao()

    override suspend fun getUsers(): Flow<Resource<List<UserItem>>> = flow {
        emit(Resource.Loading())

        //GetFromDb
        emit(Resource.Success(usersDao.getAllUsers()))

        try {
            //GetFromApi
            val apiUsers = usersApi.getUsers()

            apiUsers.let {
                delay(3000)
                database.withTransaction {
                    usersDao.deleteAllUsers()
                    usersDao.insertUsers(it.map { it.toUserItem() })
                }
            }

            //Update from api
            emit(Resource.Success(usersDao.getAllUsers()))

        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops something went wrong! " + e.message
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Oops something went wrong! " + e.message
                )
            )
        }
    }
}


//emit(Resource.Success(usersDao.getAllUsers())
//
//emit(Resource.Success(usersApi.getUsers()))