package com.tenz.tenzkotlindemo.widget.dialog

import android.util.SparseArray
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes


class ViewHolder {

    companion object{
        lateinit var views: SparseArray<View>
        lateinit var convertView: View

        fun create(view: View): ViewHolder {
            return ViewHolder(view)
        }
    }

    private constructor(view: View){
        convertView = view
        views = SparseArray()
    }

    /**
     * 获取View
     *
     * @param viewId
     * @param <T>
     * @return
    </T> */
    fun <T : View> getView(@IdRes viewId: Int): View? {
        var view: View? = views.get(viewId)
        if (view == null) {
            view = convertView.findViewById(viewId)
            views.put(viewId, view)
        }
        return view
    }

    /**
     * 设置文本
     *
     * @param viewId
     * @param text
     */
    fun setText(viewId: Int, text: String) {
        val textView = getView<View>(viewId) as TextView
        textView.setText(text)
    }

    /**
     * 设置字体颜色
     *
     * @param viewId
     * @param colorId
     */
    fun setTextColor(viewId: Int, colorId: Int) {
        val textView = getView<View>(viewId) as TextView
        textView.setTextColor(colorId)
    }

    /**
     * 设置背景图片
     *
     * @param viewId
     * @param resId
     */
    fun setBackgroundResource(viewId: Int, resId: Int) {
        val view = getView<View>(viewId)
        view!!.setBackgroundResource(resId)
    }

    /**
     * 设置背景颜色
     *
     * @param viewId
     * @param colorId
     */
    fun setBackgroundColor(viewId: Int, colorId: Int) {
        val view = getView<View>(viewId)
        view!!.setBackgroundColor(colorId)
    }

    /**
     * 设置点击事件
     *
     * @param viewId
     * @param listener
     */
    fun setOnClickListener(viewId: Int, listener: View.OnClickListener) {
        val view = getView<View>(viewId)
        view!!.setOnClickListener(listener)
    }

}