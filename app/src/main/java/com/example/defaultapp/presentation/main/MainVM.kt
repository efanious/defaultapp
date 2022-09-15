package com.example.defaultapp.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.defaultapp.data.dto.UserItemDto
import com.example.defaultapp.repository.UsersRepositoryImpl
import com.example.defaultapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(private val usersRepositoryImpl: UsersRepositoryImpl) :
    ViewModel() {

    private val _response = MutableLiveData<Resource<List<UserItemDto>>>()

    val response: LiveData<Resource<List<UserItemDto>>>
        get() = _response

    fun getUsers() {

        viewModelScope.launch {

            usersRepositoryImpl.getUsers().collect { result ->

                when (result) {
                    is Resource.Success -> {
                        _response.postValue(Resource.Success(result.data))
                    }
                    is Resource.Error -> {
                        _response.postValue(result.message?.let { Resource.Error(it) })
                    }
                    is Resource.Loading -> {
                        _response.postValue(Resource.Loading(null))
                    }
                }
            }
        }
    }
}