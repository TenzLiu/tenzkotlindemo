package com.tenz.tenzkotlindemo.util

import android.content.Context
import com.tenz.tenzkotlindemo.app.AppApplication
import com.tenz.tenzkotlindemo.app.Constants

class PreferencesUtil {

    companion object{

        /**
         * 存储数据
         */
        fun put(key: String, obj: Any){
            val sharedPreferences = AppApplication.mContext.getSharedPreferences(
                Constants.KEY_SP_NAME,
                Context.MODE_PRIVATE
            )
            val edit = sharedPreferences.edit()
            when(obj){
                is Long -> edit.putLong(key, obj)
                is Int -> edit.putInt(key, obj)
                is Float -> edit.putFloat(key, obj)
                is Boolean -> edit.putBoolean(key, obj)
                is String -> edit.putString(key, obj)
            }
            edit.apply()
        }

        /**
         * 获取存储的数据
         */
        fun get(key: String, obj: Any): Any?{
            val sharedPreferences = AppApplication.mContext.getSharedPreferences(
                Constants.KEY_SP_NAME,
                Context.MODE_PRIVATE
            )
            when(obj){
                is Long -> return sharedPreferences.getLong(key, obj)
                is Int -> return sharedPreferences.getInt(key, obj)
                is Float -> return sharedPreferences.getFloat(key, obj)
                is Boolean -> return sharedPreferences.getBoolean(key, obj)
                is String -> return sharedPreferences.getString(key, obj)
                else -> return null
            }
        }

    }

}
