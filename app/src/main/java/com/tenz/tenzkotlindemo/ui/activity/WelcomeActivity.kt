package com.tenz.tenzkotlindemo.ui.activity

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Handler
import com.tenz.tenzkotlindemo.R
import com.tenz.tenzkotlindemo.app.Constants
import com.tenz.tenzkotlindemo.base.BaseActivity
import com.tenz.tenzkotlindemo.util.AppUtil
import com.tenz.tenzkotlindemo.util.LogUtil
import com.tenz.tenzkotlindemo.util.PreferencesUtil
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_welcome

    override fun initData() {
        tv_welcome_tip.text = "欢迎使用" + AppUtil.getAppName(mContext)
        tv_version.text = "version：" + AppUtil.getVersionName(mContext)

        //改为lottie动画
        iav_welcome.addAnimatorListener(object: Animator.AnimatorListener{
            override fun onAnimationRepeat(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                //判断是否已登录
                if(PreferencesUtil.get(Constants.KEY_IS_LOGIN, false) as Boolean){
                    startActivity(Intent(mContext, MainActivity::class.java))
                }else{
                    startActivity(Intent(mContext, LoginActivity::class.java))
                }
                finish()
            }

            override fun onAnimationCancel(p0: Animator?) {

            }

            override fun onAnimationStart(p0: Animator?) {

            }
        })

        /*Handler().postDelayed(Runnable { kotlin.run {
            //判断是否已登录
            if(PreferencesUtil.get(Constants.KEY_IS_LOGIN, false) as Boolean){
                startActivity(Intent(mContext, MainActivity::class.java))
            }else{
                startActivity(Intent(mContext, LoginActivity::class.java))
            }
            finish()
        } },2000)

        val alphaAnimator = ObjectAnimator.ofFloat(rl_container, "alpha", 0.3f, 1f)
        alphaAnimator.duration = 1500
        alphaAnimator.start()*/

        LogUtil.e("appName:" + AppUtil.getAppName(mContext))
        LogUtil.e("appVersionCode:" + AppUtil.getVersionCode(mContext))
        LogUtil.e("appVersionName:" + AppUtil.getVersionName(mContext))
        LogUtil.e("appPackageName:" + AppUtil.getPackageName(mContext))
    }

}