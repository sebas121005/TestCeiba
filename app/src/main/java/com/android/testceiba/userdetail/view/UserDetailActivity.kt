package com.android.testceiba.userdetail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.testceiba.R
import com.android.testceiba.databinding.ActivityUserDetailBinding
import com.android.testceiba.userdetail.model.Post
import com.android.testceiba.userdetail.view.adapter.UserDetailAdapter
import com.android.testceiba.userdetail.viewmodel.UserDetailViewModel

class UserDetailActivity : AppCompatActivity() {
    private var mActivityUserDetailBinding: ActivityUserDetailBinding? = null

    private var mDetailAdapter: UserDetailAdapter? = null

    private var mDetailVieModel: UserDetailViewModel? = null

    private var dataListPost = ArrayList<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityUserDetailBinding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(mActivityUserDetailBinding?.root)
    }

    fun initializeWidgets() {
        mDetailAdapter = UserDetailAdapter(this, dataListPost)
        with(mActivityUserDetailBinding?.listPost) {
            this?.layoutManager = LinearLayoutManager(this@UserDetailActivity)
            this?.adapter = mDetailAdapter
        }
    }
}