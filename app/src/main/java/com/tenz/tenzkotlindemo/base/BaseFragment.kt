package com.tenz.tenzkotlindemo.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tenz.tenzkotlindemo.widget.titlebar.TitleBar
import kotlinx.android.synthetic.main.view_title_bar.*

/**
 * BaseFragment
 */
abstract class BaseFragment: Fragment(){

    open lateinit var mContext: Context
    open lateinit var mActivity: Activity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
        mActivity = activity as Activity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayout(), container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initData()
    }

    /**
     * 设置布局资源文件
     */
    abstract fun getLayout(): Int

    /**
     * 初始化控件
     */
    protected open fun initView(){

    }

    /**
     * 初始化数据
     */
    protected open fun initData(){

    }

    /**
     * 初始化titleBar
     */
    fun initTitleBar(titleBar: TitleBar, title: String, more: String?, isBackGone: Boolean?){
        titleBar.setOnTitleBarClickListener(mActivity as BaseActivity)
        titleBar.tv_title.text = title
        if(null == more){
            titleBar.tv_more.visibility = View.GONE
        }else{
            titleBar.tv_more.text = more
        }
        if(isBackGone!!){
            iv_back.visibility = View.GONE
        }
    }

}