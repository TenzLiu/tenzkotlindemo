package com.tenz.tenzkotlindemo.ui.activity

import android.content.Intent
import android.view.View
import com.tenz.tenzkotlindemo.app.Constants
import com.tenz.tenzkotlindemo.R
import com.tenz.tenzkotlindemo.base.BaseActivity
import com.tenz.tenzkotlindemo.util.PreferencesUtil
import com.tenz.tenzkotlindemo.util.ToastUtil
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: BaseActivity(){

    var mAccount: String = ""
    var mPassword: String  = ""


    override fun getLayoutId(): Int = R.layout.activity_login

    override fun initView() {
        tv_register.setOnClickListener(View.OnClickListener {
            ToastUtil.toast("register")
        })
        tv_forget_password.setOnClickListener(View.OnClickListener {
            ToastUtil.toast("forgetPassword")
        })
        btn_login.setOnClickListener(View.OnClickListener {
            mAccount = et_account.text.toString().trim()
            mPassword = et_password.text.toString().trim()
            if("".equals(mAccount) || "".equals(mPassword)){
                ToastUtil.toast("账号跟密码不能为空")
            }else{
                PreferencesUtil.put(Constants.KEY_IS_LOGIN, true)
                ToastUtil.toast("登录成功")
                startActivity(Intent(mContext, MainActivity::class.java))
                finish()
            }
        })
    }

}