package com.example.learnmvp.presenter

import android.content.Context
import android.widget.Toast
import com.example.learnmvp.ILoginView
import com.example.learnmvp.model.IUserLoginListener
import com.example.learnmvp.model.IUserLoginModel
import com.example.learnmvp.model.UserLoginModelImpl

/**
 * description:
 * Created by dailei on 2020/12/18
 *
 */
class LoginPresenter(
    private var mContext: Context,
    private var mLoginView: ILoginView
) {
    private var mUserLoginModel:IUserLoginModel = UserLoginModelImpl()

    fun login(username: String?, password: String?) {
        if (username == null || password == null) {
            Toast.makeText(mContext, "请输入你的用户名密码", Toast.LENGTH_LONG).show()
        } else {
            mLoginView.showLoading()
            mUserLoginModel.login(username, password, object : IUserLoginListener {
                override fun loginSuccess() {
                    mLoginView.success()
                    mLoginView.hideLoading()
                }

                override fun loginFailed() {
                    mLoginView.failed()
                    mLoginView.hideLoading()
                }
            })
        }
    }

    fun clear() {
        mLoginView.clear()
    }
}