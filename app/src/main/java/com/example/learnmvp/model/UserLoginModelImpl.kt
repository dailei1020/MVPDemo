package com.example.learnmvp.model

import android.os.Handler

class UserLoginModelImpl : IUserLoginModel {
    override fun login(username: String, password: String, iUserLoginListener: IUserLoginListener) {
        Handler().postDelayed(Runnable {
            if("dl" == username && "dl" == password) {
                iUserLoginListener.loginSuccess()
            } else{
                iUserLoginListener.loginFailed()
            }
        },2000)

    }
}