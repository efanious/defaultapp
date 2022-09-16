package com.example.defaultapp.presentation.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.defaultapp.R
import com.example.defaultapp.adapters.UserAdapter
import com.example.defaultapp.util.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val usersRView: RecyclerView = findViewById(R.id.users_recycler_view)
        usersRView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //Divider
        usersRView.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        val userAdapter = UserAdapter()
        viewModel.getUsers()

        viewModel.response.observe(this) { result ->
            when (result) {
                is Resource.Success -> {
                    userAdapter.data = result.data!!
                    usersRView.adapter = userAdapter
                }
                is Resource.Error -> {
                    Toast.makeText(this, result.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {

                }
            }
        }
    }
}


// TODO: Add empty view for no internet and empty list
