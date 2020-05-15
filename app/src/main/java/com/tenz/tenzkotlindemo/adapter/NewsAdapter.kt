package com.tenz.tenzkotlindemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tenz.tenzkotlindemo.R

class NewsAdapter(var context: Context, var itemList: List<String>, var onItemClickListener: PhotosAdapter.OnItemClickListener):
    RecyclerView.Adapter<NewsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ll_container.setOnClickListener(View.OnClickListener {
            onItemClickListener!!.onItemClick(position)
        })
    }


    class ViewHolder: RecyclerView.ViewHolder{

        var ll_container: LinearLayout
        var iv_icon: ImageView
        var tv_title: TextView
        var tv_time: TextView
        var tv_author: TextView

        constructor(itemView: View): super(itemView){
            ll_container = itemView.findViewById(R.id.ll_container)
            iv_icon = itemView.findViewById(R.id.iv_icon)
            tv_title = itemView.findViewById(R.id.tv_title)
            tv_time = itemView.findViewById(R.id.tv_time)
            tv_author = itemView.findViewById(R.id.tv_author)
        }

    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

}