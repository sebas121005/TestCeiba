package com.android.testceiba.usermain.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.testceiba.databinding.ItemUserBinding
import com.android.testceiba.usermain.model.User

class UserMainAdapter(private val context: Context, private val listUsers: List<User>):
        RecyclerView.Adapter<UserMainAdapter.ViewHolderUser>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUser {
                return ViewHolderUser(ItemUserBinding.inflate(LayoutInflater.from(context), parent, false))
        }

        override fun onBindViewHolder(holder: ViewHolderUser, position: Int) {
                holder.addItemUser(listUsers[position])
        }

        override fun getItemCount(): Int {
                TODO("Not yet implemented")
        }

        class ViewHolderUser(private val itemUserBinding: ItemUserBinding?):
                RecyclerView.ViewHolder(itemUserBinding!!.root) {
                fun addItemUser(user: User) {
                        itemUserBinding?.userName?.text = user.name
                        itemUserBinding?.userPhone?.text = user.phone
                        itemUserBinding?.userEmail?.text = user.email
                }

        }

}