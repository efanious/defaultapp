package com.example.defaultapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.defaultapp.R
import com.example.defaultapp.data.dto.UserItemDto

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var data = listOf<UserItemDto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item_view, parent, false)
        return UserViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size


    class UserViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private var user: UserItemDto? = null

        private val userNameText: TextView = itemView.findViewById(R.id.username_text)
        private val emailText: TextView = itemView.findViewById(R.id.email_text)

        init {
            itemView.setOnClickListener {
                user?.let {
                    onClick(it)
                }
            }
        }

        private fun onClick(userClicked: UserItemDto) {

            Toast.makeText(
                itemView.context,
                "${userClicked.username} clicked!!! ",
                Toast.LENGTH_SHORT
            ).show()

        }

        fun bind(mUser: UserItemDto) {
            user = mUser
            userNameText.text = user!!.username
            emailText.text = user!!.email

        }


    }


}