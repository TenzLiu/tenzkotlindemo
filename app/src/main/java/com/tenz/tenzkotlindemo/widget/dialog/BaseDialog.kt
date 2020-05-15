package com.tenz.tenzkotlindemo.widget.dialog

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.annotation.FloatRange
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.annotation.StyleRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.tenz.tenzkotlindemo.R


abstract class BaseDialog: DialogFragment(){


    @LayoutRes
    protected var mLayoutResId: Int = 0

    private var mDimAmount = 0.5f//背景昏暗度
    private var mShowBottomEnable: Boolean = false//是否底部显示
    private var mMargin = 0//左右边距
    private var mAnimStyle = 0//进入退出动画
    private var mOutCancel = true//点击外部取消
    private var mContext: Context? = null
    private var mWidth: Int = 0
    private var mHeight: Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.BaseDialog)
        mLayoutResId = setUpLayoutId()
    }

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(mLayoutResId, container, false)
        convertView(ViewHolder.create(view), this)
        return view
    }

    override fun onStart() {
        super.onStart()
        initParams()
    }

    /**
     * 初始化
     */
    private fun initParams() {
        val window = dialog!!.window
        if (window != null) {
            val params = window.attributes
            params.dimAmount = mDimAmount

            //设置dialog显示位置
            if (mShowBottomEnable) {
                params.gravity = Gravity.BOTTOM
            }

            //设置dialog宽度
            if (mWidth == 0) {
                params.width = WindowManager.LayoutParams.WRAP_CONTENT
            } else {
                params.width = dp2px(context!!, mWidth.toFloat())
            }

            //设置dialog高度
            if (mHeight == 0) {
                params.height = WindowManager.LayoutParams.WRAP_CONTENT
            } else {
                params.height = dp2px(context!!, mHeight.toFloat())
            }

            //设置dialog动画
            if (mAnimStyle != 0) {
                window.setWindowAnimations(mAnimStyle)
            }

            window.attributes = params
        }
        isCancelable = mOutCancel
    }

    /**
     * 设置背景昏暗度
     *
     * @param dimAmount
     * @return
     */
    fun setDimAmout(@FloatRange(from = 0.0, to = 1.0) dimAmount: Float): BaseDialog {
        mDimAmount = dimAmount
        return this
    }

    /**
     * 是否显示底部
     *
     * @param showBottom
     * @return
     */
    fun setShowBottom(showBottom: Boolean): BaseDialog {
        mShowBottomEnable = showBottom
        return this
    }

    /**
     * 设置宽高
     *
     * @param width
     * @param height
     * @return
     */
    fun setSize(width: Int, height: Int): BaseDialog {
        mWidth = width
        mHeight = height
        return this
    }

    /**
     * 设置左右margin
     *
     * @param margin
     * @return
     */
    fun setMargin(margin: Int): BaseDialog {
        mMargin = margin
        return this
    }

    /**
     * 设置进入退出动画
     *
     * @param animStyle
     * @return
     */
    fun setAnimStyle(@StyleRes animStyle: Int): BaseDialog {
        mAnimStyle = animStyle
        return this
    }

    /**
     * 设置是否点击外部取消
     *
     * @param outCancel
     * @return
     */
    fun setOutCancel(outCancel: Boolean): BaseDialog {
        mOutCancel = outCancel
        return this
    }

    fun show(manager: FragmentManager): BaseDialog {
        super.show(manager, System.currentTimeMillis().toString())
        return this
    }

    /**
     * 设置dialog布局
     *
     * @return
     */
    abstract fun setUpLayoutId(): Int

    /**
     * 操作dialog布局
     *
     * @param holder
     * @param dialog
     */
    abstract fun convertView(holder: ViewHolder, dialog: BaseDialog)

    /**
     * 获取屏幕宽度
     *
     * @param context
     * @return
     */
    fun getScreenWidth(context: Context): Int {
        val displayMetrics = context.getResources().getDisplayMetrics()
        return displayMetrics.widthPixels
    }

    fun dp2px(context: Context, dipValue: Float): Int {
        val scale = context.getResources().getDisplayMetrics().density
        return (dipValue * scale + 0.5f).toInt()
    }

}