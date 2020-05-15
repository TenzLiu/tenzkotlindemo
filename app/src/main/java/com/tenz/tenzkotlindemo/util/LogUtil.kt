package com.tenz.tenzkotlindemo.util

import android.util.Log
import com.tenz.tenzkotlindemo.app.Constants

class LogUtil {

    companion object{

        fun d(message: String){
            Log.d(Constants.LOG_TAG,message)
        }

        fun e(message: String){
            Log.e(Constants.LOG_TAG,message)
        }

    }

}