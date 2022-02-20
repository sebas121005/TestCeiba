package com.android.testceiba.userdetail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.testceiba.R
import com.android.testceiba.databinding.ActivityMainBinding

class UserDetailActivity : AppCompatActivity() {
    private var mActivityUserDetailBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityUserDetailBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mActivityUserDetailBinding?.root)
    }

    fun initializeWidgets() {

    }
}