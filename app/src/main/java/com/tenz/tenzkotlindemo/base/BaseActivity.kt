package com.tenz.tenzkotlindemo.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.IBinder
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.tenz.tenzkotlindemo.R
import com.tenz.tenzkotlindemo.util.StatusBarUtil
import com.tenz.tenzkotlindemo.widget.titlebar.TitleBar
import kotlinx.android.synthetic.main.view_title_bar.*


/**
 * BaseActivity
 */
abstract class BaseActivity: AppCompatActivity(), TitleBar.OnTitleBarClickListener{

    protected lateinit var mContext: Context
    protected lateinit var mActivity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initStatusBar()
        setContentView(getLayoutId())

        mContext = this
        mActivity = this
        initView()
        initData()
    }

    open fun initStatusBar() {
        StatusBarUtil.setColor(this,resources.getColor(R.color.colorApp),0)
    }

    /**
     * 设置布局资源文件
     */
    abstract fun getLayoutId(): Int

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
        titleBar.setOnTitleBarClickListener(this)
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

    /**
     * 点击空白区域隐藏键盘.
     */
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {  //把操作放在用户点击的时候
            val v = currentFocus      //得到当前页面的焦点,ps:有输入框的页面焦点一般会被输入框占据
            if (isShouldHideKeyboard(v, ev)) { //判断用户点击的是否是输入框以外的区域
                hideKeyboard(v!!.windowToken)   //收起键盘
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时则不能隐藏
     *
     * @param v
     * @param event
     * @return
     */
    private fun isShouldHideKeyboard(v: View?, event: MotionEvent): Boolean {
        if (v != null && v is EditText) {  //判断得到的焦点控件是否包含EditText
            val l = intArrayOf(0, 0)
            v!!.getLocationInWindow(l)
            val left = l[0]
            //得到输入框在屏幕中上下左右的位置
            val top = l[1]
            val bottom = top + v!!.getHeight()
            val right = left + v!!.getWidth()
            return if (event.x > left && event.x < right
                && event.y > top && event.y < bottom
            ) {
                // 点击位置如果是EditText的区域，忽略它，不收起键盘。
                false
            } else {
                true
            }
        }
        // 如果焦点不是EditText则忽略
        return false
    }

    /**
     * 获取InputMethodManager，隐藏软键盘
     * @param token
     */
    private fun hideKeyboard(token: IBinder?) {
        if (token != null) {
            val im = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            im!!.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    /**
     * 返回
     */
    override fun back() {
        finish()
    }

    /**
     * 更多
     */
    override fun more() {

    }

}