package com.androidnexos.testceiba.usermain.view.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidnexos.testceiba.usermain.model.User

class UserMainAdapter(private val context: Context, private val listUsers: List<User>):
        RecyclerView.Adapter<UserMainAdapter.ViewHolderUser>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUser {
                TODO("Not yet implemented")
        }

        override fun onBindViewHolder(holder: ViewHolderUser, position: Int) {
                TODO("Not yet implemented")
        }

        override fun getItemCount(): Int {
                TODO("Not yet implemented")
        }

        class ViewHolderUser(): RecyclerView.ViewHolder() {

        }

}