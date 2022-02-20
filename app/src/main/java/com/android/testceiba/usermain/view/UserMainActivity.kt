package com.android.testceiba.usermain.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.android.testceiba.R
import com.android.testceiba.api.UserRepository
import com.android.testceiba.api.WebService
import com.android.testceiba.databinding.ActivityMainBinding
import com.android.testceiba.db.UserDBImplement
import com.android.testceiba.userdetail.view.UserDetailActivity
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
        const val USER_ID = "ID"
        const val USER_NAME = "NAME"
        const val USER_PHONE = "PHONE"
        const val USER_EMAIL = "EMAIL"
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
        mMainViewModel?.showLoadingLiveData?.value = true
        mMainViewModel?.getUsers()

        mMainBinding?.searchUsers?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0!!.isNotEmpty()) {
                    validateFilterList(mUserMainAdapter?.filter(p0.toString()))
                } else {
                    mMainViewModel?.getUsers()
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        mUserMainAdapter?.setPostOnClickListener {
            val user = dataListUser[mMainBinding?.listUsers?.getChildAdapterPosition(it)!!]
            startActivity(Intent(this, UserDetailActivity::class.java)
                .putExtra(USER_ID, user.id)
                .putExtra(USER_NAME, user.name)
                .putExtra(USER_PHONE, user.phone)
                .putExtra(USER_EMAIL, user.email))
        }
    }

    private fun observables() {
        mMainViewModel?.getUserLiveData?.observe(this, {
            dataListUser.clear()
            dataListUser.addAll(it)
            mUserMainAdapter?.notifyDataSetChanged()
        })

        mMainViewModel?.showLoadingLiveData?.observe(this, {
            if (it) {
                mMainBinding?.loading?.visibility = View.VISIBLE
            } else {
                mMainBinding?.loading?.visibility = View.GONE
            }
        })
    }

    private fun validateFilterList(filterList: List<User>?) {
        if (filterList?.size != 0) {
            dataListUser.clear()
            dataListUser.addAll(filterList!!)
            mUserMainAdapter?.notifyDataSetChanged()
        } else {
            mMainViewModel?.getUsers()
            Toast.makeText(this@UserMainActivity, getString(R.string.lista_empty), Toast.LENGTH_SHORT).show()
        }
    }
}