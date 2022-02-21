package com.android.testceiba.usermain.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.testceiba.databinding.ItemUserBinding
import com.android.testceiba.usermain.model.User
import java.util.*
import kotlin.collections.ArrayList

class UserMainAdapter(private val context: Context, private val listUsers: List<User>):
        RecyclerView.Adapter<UserMainAdapter.ViewHolderUser>(), View.OnClickListener {
        var mListenerPost: View.OnClickListener? = null

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUser {
                val view =  ItemUserBinding.inflate(LayoutInflater.from(context), parent, false)
                view.root.setOnClickListener(this)
                return ViewHolderUser (view)
        }

        override fun onBindViewHolder(holder: ViewHolderUser, position: Int) {
                holder.addItemUser(listUsers[position])
                holder.onClickListener(mListenerPost!!)
        }

        override fun getItemCount(): Int {
                return listUsers.size
        }

        override fun onClick(view: View?) {
                mListenerPost?.onClick(view)
        }

        fun setPostOnClickListener(listener: View.OnClickListener) {
               mListenerPost = listener
        }

        fun filter(textForTheFilter: String): List<User> {
                val filteredList = ArrayList<User>()
                if (textForTheFilter.isEmpty()) {
                        filteredList.addAll(listUsers)
                } else {
                        val filterPattern = textForTheFilter.lowercase(Locale.getDefault())
                        for (mUser in listUsers) {
                                val validateText = mUser.name.lowercase(Locale.getDefault())
                                if (validateText.contains(filterPattern)) {
                                        filteredList.add(mUser)
                                }

                        }
                }
                return filteredList
        }

        class ViewHolderUser(private val itemUserBinding: ItemUserBinding?):
                RecyclerView.ViewHolder(itemUserBinding!!.root) {
                fun addItemUser(user: User) {
                        itemUserBinding?.userName?.text = user.name
                        itemUserBinding?.userPhone?.text = user.phone
                        itemUserBinding?.userEmail?.text = user.email
                }

                fun onClickListener(listener: View.OnClickListener) {
                        itemUserBinding?.seePublications?.setOnClickListener {
                                listener.onClick(itemUserBinding.root)
                        }
                }

        }

}