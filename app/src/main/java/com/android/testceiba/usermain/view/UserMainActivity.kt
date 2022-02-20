package com.android.testceiba.usermain.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.android.testceiba.R
import com.android.testceiba.api.UserRepository
import com.android.testceiba.api.WebService
import com.android.testceiba.databinding.ActivityMainBinding
import com.android.testceiba.db.UserDBImplement
import com.android.testceiba.usermain.model.User
import com.android.testceiba.usermain.view.adapter.UserMainAdapter
import com.android.testceiba.usermain.viewmodel.UserMainViewModel

class UserMainActivity : AppCompatActivity() {
    private var mMainBinding: ActivityMainBinding? = null
    private var mMainViewModel: UserMainViewModel? = null

    private var mUserMainAdapter: UserMainAdapter? = null

    private var dataListUser = ArrayList<User>()

    companion object {
        const val DB_NAME = "USER_DB"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mMainBinding?.root)

        initializeWidgets()
        observables()

    }

    private fun initializeWidgets() {
        mUserMainAdapter = UserMainAdapter(this, dataListUser)
        with(mMainBinding?.listUsers) {
            this?.layoutManager = LinearLayoutManager(this@UserMainActivity)
            this?.adapter = mUserMainAdapter
        }

        mMainViewModel = ViewModelProvider(this)[UserMainViewModel::class.java]
        mMainViewModel?.mUserRepository = UserRepository(WebService.getInstance())
        mMainViewModel?.mRoomImpl = Room.databaseBuilder(this, UserDBImplement::class.java, DB_NAME).build()
        mMainViewModel?.getUsers()
    }

    private fun observables() {
        mMainViewModel?.getUserLiveData?.observe(this, {
            dataListUser.clear()
            dataListUser.addAll(it)
            mUserMainAdapter?.notifyDataSetChanged()
        })
    }
}