package com.tenz.tenzkotlindemo.util

import android.content.Context

class AppUtil {

    companion object{

        /**
         * 获取APP名称
         */
        fun getAppName(context: Context): String{
            try {
                val packageManager = context.packageManager
                val packageInfo = packageManager.getPackageInfo(context.packageName, 0)
                val labelRes = packageInfo.applicationInfo.labelRes
                val appName = context.resources.getString(labelRes)
                return appName
            }catch (e: Exception){
                e.printStackTrace()
                return ""
            }
        }

        /**
         * 获取APP版本号
         */
        fun getVersionCode(context: Context): Int{
            try {
                val packageManager = context.packageManager
                val packageInfo = packageManager.getPackageInfo(context.packageName, 0)
                val versionCode = packageInfo.versionCode
                return versionCode
            }catch (e: Exception){
                e.printStackTrace()
                return 0
            }
        }

        /**
         * 获取APP版本名称
         */
        fun getVersionName(context: Context): String{
            try {
                val packageManager = context.packageManager
                val packageInfo = packageManager.getPackageInfo(context.packageName, 0)
                val versionName = packageInfo.versionName
                return versionName
            }catch (e: Exception){
                e.printStackTrace()
                return ""
            }
        }

        /**
         * 获取APP包名称
         */
        fun getPackageName(context: Context): String{
            try {
                val packageManager = context.packageManager
                val packageInfo = packageManager.getPackageInfo(context.packageName, 0)
                val packageName = packageInfo.packageName
                return packageName
            }catch (e: Exception){
                e.printStackTrace()
                return ""
            }
        }

    }

}