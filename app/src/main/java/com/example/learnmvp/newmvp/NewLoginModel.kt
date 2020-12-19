package com.example.learnmvp.newmvp

import android.os.Handler
import com.example.learnmvp.model.IUserLoginListener

/**
 * description:
 * Created by dailei on 2020/12/18
 *
 */
class NewLoginModel :LoginContract.Model{

    override fun login(userName: String, passWord: String, userLoginListener: IUserLoginListener) {
        Handler().postDelayed(Runnable {
            if("dl" == userName && "dl" == passWord) {
                userLoginListener.loginSuccess()
            } else{
                userLoginListener.loginFailed()
            }
        },2000)

    }
}