package com.example.defaultapp.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.defaultapp.R
import com.example.defaultapp.models.UserItem
import com.example.defaultapp.presentation.user_detail.UserDetailActivity

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var data = listOf<UserItem>()

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

        private var user: UserItem? = null

        private val userNameText: TextView = itemView.findViewById(R.id.username_text)
        private val emailText: TextView = itemView.findViewById(R.id.email_text)

        init {
            itemView.setOnClickListener {
                user?.let {
                    onClick(it)
                }
            }
        }

        private fun onClick(userClicked: UserItem) {

            val intent = Intent(itemView.context, UserDetailActivity::class.java)
            intent.putExtra("User", userClicked)
            itemView.context.startActivity(intent)

        }

        fun bind(mUser: UserItem) {
            user = mUser
            userNameText.text = user!!.username
            emailText.text = user!!.email

        }


    }


}