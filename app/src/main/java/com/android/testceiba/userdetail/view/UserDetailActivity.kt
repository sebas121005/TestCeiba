package com.android.testceiba.userdetail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.testceiba.R
import com.android.testceiba.api.UserRepository
import com.android.testceiba.api.WebService
import com.android.testceiba.databinding.ActivityUserDetailBinding
import com.android.testceiba.userdetail.model.Post
import com.android.testceiba.userdetail.view.adapter.UserDetailAdapter
import com.android.testceiba.userdetail.viewmodel.UserDetailViewModel
import com.android.testceiba.usermain.view.UserMainActivity

class UserDetailActivity : AppCompatActivity() {
    private var mActivityUserDetailBinding: ActivityUserDetailBinding? = null

    private var mDetailAdapter: UserDetailAdapter? = null

    private var mDetailVieModel: UserDetailViewModel? = null

    private var dataListPost = ArrayList<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityUserDetailBinding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(mActivityUserDetailBinding?.root)

        initializeWidgets()
        observables()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun initializeWidgets() {
        mDetailAdapter = UserDetailAdapter(this, dataListPost)
        with(mActivityUserDetailBinding?.listPost) {
            this?.layoutManager = LinearLayoutManager(this@UserDetailActivity)
            this?.adapter = mDetailAdapter
        }

        mDetailVieModel = ViewModelProvider(this).get(UserDetailViewModel::class.java)
        mDetailVieModel?.mUserRepository = UserRepository(WebService.getInstance())
        mDetailVieModel?.showLoadingLiveData?.value = true
        intent.extras?.let {
            mDetailVieModel?.getPosts(it.getInt(UserMainActivity.USER_ID).toString())
            showUser(it.getString(UserMainActivity.USER_NAME), it.getString(UserMainActivity.USER_PHONE),
            it.getString(UserMainActivity.USER_EMAIL))
        }
    }

    private fun observables() {
        mDetailVieModel?.getPostLiveData?.observe(this, {
            dataListPost.clear()
            dataListPost.addAll(it)
            mDetailAdapter?.notifyDataSetChanged()
        })

        mDetailVieModel?.showLoadingLiveData?.observe(this, {
            if (it) {
                mActivityUserDetailBinding?.loading?.visibility = View.VISIBLE
            } else {
                mActivityUserDetailBinding?.loading?.visibility = View.GONE
            }
        })
    }

    private fun showUser(userName: String?, phone: String?, email: String?) {
        mActivityUserDetailBinding?.userName?.text = userName
        mActivityUserDetailBinding?.userPhone?.text = phone
        mActivityUserDetailBinding?.userEmail?.text = email

    }
}