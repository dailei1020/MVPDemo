package com.example.learnmvp.newmvp

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.learnmvp.R
import com.example.learnmvp.base.BaseActivity

class NewMvpActivity : BaseActivity<NewLoginPresenter, NewLoginModel>(), View.OnClickListener,
    LoginContract.View {
    private lateinit var editUserName: EditText
    private lateinit var editPassWord: EditText
    private lateinit var btnLogin: AppCompatButton
    private lateinit var btnClear: AppCompatButton
    private lateinit var progressDialog: ProgressDialog

    override fun initLayout(): Int {
        return R.layout.activity_mvp_login
    }

    override fun initPresenter() {
        mPresenter!!.setViewAndModel(this, mModel!!)
    }

    override fun initListener() {
        btnLogin.setOnClickListener(this)
        btnClear.setOnClickListener(this)
    }

    @SuppressLint("WrongViewCast")
    override fun initView() {
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("登录中,请稍后")
        progressDialog.setCancelable(false)

        editUserName = findViewById(R.id.edit_account)
        editPassWord = findViewById(R.id.edit_pwd)
        btnLogin = findViewById(R.id.btn_login)
        btnClear = findViewById(R.id.btn_clear)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btn_login -> {
                mPresenter!!.login(
                    editUserName.text.toString(),
                    editPassWord.text.toString()
                )
            }
            R.id.btn_clear -> {
                mPresenter!!.clear()
            }
        }
    }

    override fun success() {
        Toast.makeText(this@NewMvpActivity, "登陆成功", Toast.LENGTH_SHORT).show()
    }

    override fun failed() {
        Toast.makeText(this@NewMvpActivity, "登陆失败", Toast.LENGTH_SHORT).show()
    }

    override fun clear() {
        editUserName.setText("")
        editPassWord.setText("")
    }

    override fun showLoading() {
        progressDialog.show()
    }

    override fun hideLoading() {
        progressDialog.hide()
    }

}