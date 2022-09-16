package com.example.defaultapp.presentation.user_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.defaultapp.R
import com.example.defaultapp.models.UserItem

class UserDetailActivity : AppCompatActivity() {

    private lateinit var user: UserItem

    private lateinit var nameTextView: TextView
    private lateinit var userNameTextView: TextView
    private lateinit var websiteTextView: TextView
    private lateinit var companyNameTextView: TextView
    private lateinit var addressTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        user = intent.getParcelableExtra("User")!!

        nameTextView = findViewById(R.id.nameTextView)
        userNameTextView = findViewById(R.id.userNameTextView)
        websiteTextView = findViewById(R.id.websiteTextView)
        companyNameTextView = findViewById(R.id.companyNameTextView)
        addressTextView = findViewById(R.id.addressTextView)


        displayInfo(user)
    }

    private fun displayInfo(user: UserItem) {

        nameTextView.text = "Name: ${user.name}"
        userNameTextView.text = "UserName: ${user.username}"
        //websiteTextView.text = user.web
        //companyNameTextView.text = user.com
        //addressTextView.text = user.add
    }
}