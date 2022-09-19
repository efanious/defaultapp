package com.example.defaultapp.di

import android.app.Application
import androidx.room.Room
import com.example.defaultapp.data.local.UsersDatabase
import com.example.defaultapp.data.remote.UsersApi
import com.example.defaultapp.repository.UsersRepository
import com.example.defaultapp.repository.UsersRepositoryImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUsersRepository(api: UsersApi, db: UsersDatabase): UsersRepository {
        return UsersRepositoryImpl(api, db)
    }

    @Provides
    @Singleton
    fun providesGson(): Gson = GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    fun providesUsers(gson: Gson): UsersApi {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(UsersApi::class.java)
    }


    @Provides
    @Singleton
    fun provideDatabase(app: Application): UsersDatabase =
        Room.databaseBuilder(app, UsersDatabase::class.java, "users_database")
            .build()

}