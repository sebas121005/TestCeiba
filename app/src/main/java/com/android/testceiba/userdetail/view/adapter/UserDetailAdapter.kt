package com.android.testceiba.userdetail.view.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.testceiba.databinding.ItemPostBinding
import com.android.testceiba.userdetail.model.Post

class UserDetailAdapter(private val context: Context, private val listPost: List<Post>)
    : RecyclerView.Adapter<UserDetailAdapter.ViewHolderDetail>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDetail {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolderDetail, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ViewHolderDetail(private val itemPostBinding: ItemPostBinding):
                    RecyclerView.ViewHolder(itemPostBinding.root) {
                        fun addPost(post: Post) {
                            itemPostBinding.postTitle.text = post.postTitle
                            itemPostBinding.postBody.text = post.postBody
                        }

    }
}