package com.example.learnmvp

/**
 * description:
 * Created by dailei on 2020/12/18
 *
 */
interface ILoginView {
    fun showLoading()
    fun hideLoading()
    fun success()
    fun failed()
    fun clear()
}