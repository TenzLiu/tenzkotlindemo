package com.tenz.tenzkotlindemo.ui.activity

import android.view.View
import com.tenz.tenzkotlindemo.R
import com.tenz.tenzkotlindemo.base.BaseActivity
import com.tenz.tenzkotlindemo.util.StatusBarUtil
import kotlinx.android.synthetic.main.activity_photos_detail.*

class PhotosDetailActivity: BaseActivity(){

    override fun getLayoutId(): Int = R.layout.activity_photos_detail

    override fun initStatusBar() {
        StatusBarUtil.setTranslucent(this, 0)
    }

    override fun initView() {
        val layoutParams = view_status_bar.layoutParams
        layoutParams.height = StatusBarUtil.getStatusBarHeight(mContext)
        view_status_bar.layoutParams = layoutParams

        iv_back.setOnClickListener(View.OnClickListener {
            back()
        })
    }

    override fun initData() {
        pv_photos_detail.setImageDrawable(resources.getDrawable(R.drawable.photos_icon))
    }

}