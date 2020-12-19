package com.example.learnmvp.model

/**
 * description:
 * Created by dailei on 2020/12/18
 *
 */
interface IUserLoginModel {
    fun login(username: String, password: String, iUserLoginListener: IUserLoginListener)
}