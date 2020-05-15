package com.tenz.tenzkotlindemo.util

import android.widget.Toast
import com.tenz.tenzkotlindemo.app.AppApplication

class ToastUtil {

    companion object{

        /**
         * toast提示
         */
        fun toast(message: String){
            Toast.makeText(AppApplication.mContext,message,Toast.LENGTH_SHORT).show()
        }

    }

}