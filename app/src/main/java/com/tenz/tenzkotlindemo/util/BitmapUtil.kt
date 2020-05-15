package com.tenz.tenzkotlindemo.util

import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_MEDIA_SCANNER_SCAN_FILE
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class BitmapUtil {

    companion object{

        /**
         * 保存图片到图库
         */
        fun saveBitmapToGallery(context: Context, bitmap: Bitmap, fileName: String): Boolean{
            val storePath = Environment.getExternalStorageDirectory().absolutePath + File.separator + "images"
            val appDir = File(storePath)
            if(!appDir.exists()){
                appDir.mkdir()
            }
            val file = File(appDir, fileName)
            try {
                val fos = FileOutputStream(file)
                //通过io流的方式来压缩保存图片(80代表压缩20%)
                val isSuccess = bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fos)
                fos.flush()
                fos.close()

                //发送广播通知系统图库刷新数据
                val uri = Uri.fromFile(file)
                context.sendBroadcast(Intent(ACTION_MEDIA_SCANNER_SCAN_FILE, uri))
                return isSuccess
            }catch (e: IOException){
                e.printStackTrace()
            }
            return false
        }

    }

}