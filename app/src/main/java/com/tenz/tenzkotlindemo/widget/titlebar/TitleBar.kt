package com.tenz.tenzkotlindemo.widget.titlebar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.tenz.tenzkotlindemo.R

/**
 * 自定义titlebar
 */
class TitleBar: RelativeLayout{

    var mContext: Context
    lateinit var iv_back: ImageView
    lateinit var tv_title: TextView
    lateinit var tv_more: TextView
    lateinit var mOnTitleBarClickListener: OnTitleBarClickListener

    fun setOnTitleBarClickListener(onTitleBarClickListener: OnTitleBarClickListener){
        mOnTitleBarClickListener = onTitleBarClickListener
    }

    fun setTitle(title: String){
        tv_title.text = title
    }

    fun setMore(more: String){
        tv_more.text = more
    }

    constructor(context: Context) : this(context, null) {
        mContext = context
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs, 0) {
        mContext = context
        init()
    }

    /**
     * 初始化
     */
    private fun init() {
        val inflate = LayoutInflater.from(mContext).inflate(R.layout.view_title_bar, this, true)
        iv_back = inflate.findViewById(R.id.iv_back)
        tv_title = inflate.findViewById(R.id.tv_title)
        tv_more = inflate.findViewById(R.id.tv_more)
        iv_back.setOnClickListener(OnClickListener {
            if(::mOnTitleBarClickListener.isInitialized){
                mOnTitleBarClickListener.back()
            }
        })
        tv_more.setOnClickListener(OnClickListener {
            if(::mOnTitleBarClickListener.isInitialized){
                mOnTitleBarClickListener.more()
            }
        })
    }

    /**
     * 点击事件接口
     */
    open interface OnTitleBarClickListener{
        fun back()
        fun more()
    }

}