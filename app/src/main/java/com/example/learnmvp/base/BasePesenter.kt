package com.example.learnmvp.base

import android.content.Context

/**
 * description:
 * Created by dailei on 2020/12/18
 *
 */
abstract class BasePresenter<T, E>() {

    var mView: T? = null
    var mModel: E? = null

    open lateinit var mContext: Context

    open fun setViewAndModel(view: T, model: E) {
        this.mView = view
        this.mModel = model
    }

}