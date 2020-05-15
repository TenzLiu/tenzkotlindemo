package com.tenz.tenzkotlindemo.widget.dialog

import androidx.annotation.LayoutRes



class CommonDialog: BaseDialog(){

    var convertListener: ViewConvertListener? = null

    companion object{

        fun newInstance(): CommonDialog {
            return CommonDialog()
        }
    }

    /**
     * 设置Dialog布局
     *
     * @param layoutId
     * @return
     */
    fun setLayoutId(@LayoutRes layoutId: Int): CommonDialog {
        this.mLayoutResId = layoutId
        return this
    }

    override fun setUpLayoutId(): Int {
        return mLayoutResId
    }

    override fun convertView(holder: ViewHolder, dialog: BaseDialog) {
        if (convertListener != null) {
            convertListener!!.convertView(holder, dialog)
        }
    }

    fun setConvertListener(convertListener: ViewConvertListener): CommonDialog {
        this.convertListener = convertListener
        return this
    }

}