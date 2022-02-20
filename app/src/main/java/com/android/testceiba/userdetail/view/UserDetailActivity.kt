package com.android.testceiba.userdetail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.testceiba.R
import com.android.testceiba.databinding.ActivityMainBinding
import com.android.testceiba.userdetail.view.adapter.UserDetailAdapter
import com.android.testceiba.userdetail.viewmodel.UserDetailViewModel

class UserDetailActivity : AppCompatActivity() {
    private var mActivityUserDetailBinding: ActivityMainBinding? = null

    private var mDetailAdapter: UserDetailAdapter? = null

    private var mDetailVieModel: UserDetailViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityUserDetailBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mActivityUserDetailBinding?.root)
    }

    fun initializeWidgets() {
        
    }
}