package com.android.testceiba.usermain.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.testceiba.R
import com.android.testceiba.databinding.ActivityMainBinding

class UserMainActivity : AppCompatActivity() {
    private var mMainBinding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mMainBinding?.root)
    }
}