package com.example.learnmvp.newmvp

import android.text.TextUtils
import android.widget.Toast
import com.example.learnmvp.model.IUserLoginListener

/**
 * description:
 * Created by dailei on 2020/12/18
 *
 */
class NewLoginPresenter:LoginContract.Presenter(){
    override fun login(userName: String, passWord: String) {
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord)) {
            Toast.makeText(mContext, "请输入你的用户名和密码", Toast.LENGTH_SHORT).show()
        } else {
            mView!!.showLoading()
            mModel!!.login(userName, passWord, object : IUserLoginListener{
                override fun loginSuccess() {
                    mView!!.success()
                    mView!!.hideLoading()
                }

                override fun loginFailed() {
                    mView!!.failed()
                    mView!!.hideLoading()
                }
            })
        }
    }

    override fun clear() {
        mView!!.clear()
    }
}