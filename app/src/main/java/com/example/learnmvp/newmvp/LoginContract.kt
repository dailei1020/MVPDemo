package com.example.learnmvp.newmvp

import com.example.learnmvp.base.BasePresenter
import com.example.learnmvp.base.IBaseModel
import com.example.learnmvp.base.IBaseView
import com.example.learnmvp.model.IUserLoginListener

/**
 * description:契约类
 * Created by dailei on 2020/12/18
 *
 */
class LoginContract {
    interface Model : IBaseModel {
        fun login(
            userName: String,
            passWord: String,
            userLoginListener: IUserLoginListener
        )

//        fun rxLogin(
//            userName: String,
//            passWord: String
//        ): Observable<String>
    }

    interface View : IBaseView {
        fun success()
        fun failed()
        fun clear()
    }

    abstract class Presenter : BasePresenter<View, Model>() {
        abstract fun login(userName: String, passWord: String)

        //abstract fun rxLogin(userName: String, passWord: String)
        abstract fun clear()
    }
}