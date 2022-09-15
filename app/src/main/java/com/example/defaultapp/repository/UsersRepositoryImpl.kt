package com.example.defaultapp.repository

import com.example.defaultapp.data.UsersApi
import com.example.defaultapp.data.dto.UserItemDto
import com.example.defaultapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class UsersRepositoryImpl @Inject constructor(private val usersApi: UsersApi) :
    UsersRepository {

    override suspend fun getUsers(): Flow<Resource<List<UserItemDto>>> = flow {
        emit(Resource.Loading())

        try {
            emit(Resource.Success(usersApi.getUsers()))

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