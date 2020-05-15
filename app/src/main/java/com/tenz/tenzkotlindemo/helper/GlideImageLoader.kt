package com.tenz.tenzkotlindemo.helper

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.youth.banner.loader.ImageLoader

/**
 * banner 图片加载
 */
class GlideImageLoader: ImageLoader(){

    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        //Glide 加载图片简单用法
        Glide.with(context!!).load(path).into(imageView!!)
    }

    override fun createImageView(context: Context?): ImageView {
        return super.createImageView(context)
    }

}