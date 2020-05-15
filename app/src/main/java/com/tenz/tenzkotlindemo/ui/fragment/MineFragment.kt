package com.tenz.tenzkotlindemo.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.TextView
import com.tenz.tenzkotlindemo.R
import com.tenz.tenzkotlindemo.app.Constants
import com.tenz.tenzkotlindemo.base.BaseFragment
import com.tenz.tenzkotlindemo.ui.activity.LoginActivity
import com.tenz.tenzkotlindemo.ui.activity.WebActivity
import com.tenz.tenzkotlindemo.util.PreferencesUtil
import com.tenz.tenzkotlindemo.util.StatusBarUtil
import com.tenz.tenzkotlindemo.widget.dialog.BaseDialog
import com.tenz.tenzkotlindemo.widget.dialog.CommonDialog
import com.tenz.tenzkotlindemo.widget.dialog.ViewConvertListener
import com.tenz.tenzkotlindemo.widget.dialog.ViewHolder
import kotlinx.android.synthetic.main.fragment_mine.*
import kotlinx.android.synthetic.main.layout_title_bar.*

class MineFragment: BaseFragment(){

    companion object{
        fun newInstance(): MineFragment{
            return MineFragment()
        }
    }

    override fun getLayout(): Int = R.layout.fragment_mine

    override fun initView() {
        /**
         * 个人中心
         */
        rl_user_info.setOnClickListener(View.OnClickListener {
            val bundle = Bundle()
            bundle.putString(WebActivity.KEY_URL, Constants.URL_AUTHOR)
            val intent = Intent(context,WebActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        })
        //系统设置
        rl_setting.setOnClickListener(View.OnClickListener {
            val intent = Intent(Settings.ACTION_SETTINGS)
            startActivity(intent)
        })
        //分享
        rl_share.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,Constants.URL_PROJECT)
            startActivity(intent)
        })
        //打赏
        rl_reward_author.setOnClickListener(View.OnClickListener {
            CommonDialog.newInstance()
                .setLayoutId(R.layout.dialog_reward_author)
                .setConvertListener(rewardAuthorViewConvertListener())
                .setShowBottom(false)
                .show(childFragmentManager)
        })
        //关于
        rl_about.setOnClickListener(View.OnClickListener {
            val bundle = Bundle()
            bundle.putString(WebActivity.KEY_URL, Constants.URL_PROJECT)
            val intent = Intent(context,WebActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        })
        //退出登录
        rl_logout.setOnClickListener(View.OnClickListener {
            PreferencesUtil.put(Constants.KEY_IS_LOGIN, false)
            startActivity(Intent(mContext,LoginActivity::class.java))
            mActivity.finish()
        })
    }

    /**
     * 打赏dialog回调
     */
    class rewardAuthorViewConvertListener: ViewConvertListener{
        override fun convertView(holder: ViewHolder, dialog: BaseDialog) {
            holder.getView<TextView>(R.id.iv_close)!!.setOnClickListener(View.OnClickListener {
                dialog.dismiss()
            })
        }

    }

}