package com.android.testceiba.usermain.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.android.testceiba.R
import com.android.testceiba.api.UserRepository
import com.android.testceiba.api.WebService
import com.android.testceiba.databinding.ActivityMainBinding
import com.android.testceiba.db.UserDBImplement
import com.android.testceiba.usermain.viewmodel.UserMainViewModel

class UserMainActivity : AppCompatActivity() {
    private var mMainBinding: ActivityMainBinding? = null
    private var mMainViewModel: UserMainViewModel? = null

    companion object {
        const val DB_NAME = "USER_DB"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mMainBinding?.root)

        mMainViewModel = ViewModelProvider(this)[UserMainViewModel::class.java]
        mMainViewModel?.mUserRepository = UserRepository(WebService.getInstance())
        mMainViewModel?.mRoomImpl = Room.databaseBuilder(this, UserDBImplement::class.java, DB_NAME).build()
        mMainViewModel?.getUsers()
    }
}