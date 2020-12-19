package com.example.learnmvp

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.learnmvp.presenter.LoginPresenter

class MvpLoginActivity : AppCompatActivity(), View.OnClickListener, ILoginView {

    private lateinit var editUserName: EditText
    private lateinit var editPassWord: EditText
    private lateinit var btnLogin: AppCompatButton
    private lateinit var btnClear: AppCompatButton
    private lateinit var mLoginPresenter: LoginPresenter
    private lateinit var mProgressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp_login)
        initView()
        initListener()
    }

    private fun initListener() {
        btnLogin.setOnClickListener(this)
        btnClear.setOnClickListener(this)
    }

    private fun initView() {
        editUserName = findViewById(R.id.edit_account)
        editPassWord = findViewById(R.id.edit_pwd)
        btnLogin = findViewById(R.id.btn_login)
        btnClear = findViewById(R.id.btn_clear)
        mLoginPresenter = LoginPresenter(this, this)
        mProgressDialog = ProgressDialog(this)
        mProgressDialog.setMessage("登陆中")
        mProgressDialog.setCancelable(false)
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.btn_login -> {
                    mLoginPresenter.login(
                        editUserName.text.toString(),
                        editPassWord.text.toString()
                    )
                }
                R.id.btn_clear -> {
                    mLoginPresenter.clear()
                }
            }
        }
    }

    override fun showLoading() {
        mProgressDialog.show()
    }

    override fun hideLoading() {
        mProgressDialog.hide()
    }

    override fun success() {
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show()
    }

    override fun failed() {
        Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show()
    }

    override fun clear() {
        editUserName.setText("")
        editPassWord.setText("")
    }
}