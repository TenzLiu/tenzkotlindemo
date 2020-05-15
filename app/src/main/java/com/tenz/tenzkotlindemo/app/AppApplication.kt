package com.tenz.tenzkotlindemo.app

import android.app.Application
import android.content.Context
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.*
import com.scwang.smartrefresh.layout.footer.BallPulseFooter
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.BezierRadarHeader
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.tenz.tenzkotlindemo.R

class AppApplication: Application(){

    companion object{

        lateinit var mApplication: Application
        lateinit var mContext: Context

    }

    init {
        //初始化SmartRefreshLayout样式
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(object: DefaultRefreshHeaderCreator{

            override fun createRefreshHeader(context: Context, layout: RefreshLayout): RefreshHeader {
                layout.setPrimaryColors(context.resources.getColor(R.color.colorApp), context.resources.getColor(R.color.colorWhite))
                return ClassicsHeader(context)
            }

        })
        SmartRefreshLayout.setDefaultRefreshFooterCreator(object: DefaultRefreshFooterCreator{

            override fun createRefreshFooter(context: Context, layout: RefreshLayout): RefreshFooter {
                return ClassicsFooter(context)
            }

        })
    }

    override fun onCreate() {
        super.onCreate()
        mApplication = this
        mContext = applicationContext
    }

}