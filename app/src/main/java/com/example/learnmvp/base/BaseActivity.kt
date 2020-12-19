package com.example.learnmvp.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learnmvp.util.MVPUtil.getT

/**
 * description:
 * Created by dailei on 2020/12/18
 */
abstract class BaseActivity<T : BasePresenter<*, *>, E : IBaseModel> : AppCompatActivity() {
    private lateinit var activity: Context
    var mPresenter: T? = null
    var mModel: E? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initLayout())
        activity = this
        mPresenter = getT(this, 0)
        mModel = getT(this, 1)
        if (null != mPresenter) {
            mPresenter!!.mContext = this
        }
        initView()
        initListener()
        initPresenter()
    }

    protected abstract fun initPresenter()
    protected abstract fun initListener()
    protected abstract fun initView()
    protected abstract fun initLayout(): Int
}