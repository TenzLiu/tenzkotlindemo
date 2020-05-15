package com.tenz.tenzkotlindemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tenz.tenzkotlindemo.R

class PhotosAdapter(var context: Context, var itemList: List<String>, var onItemClickListener: OnItemClickListener):
    RecyclerView.Adapter<PhotosAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_photos, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val layoutParams = holder.iv_icon.layoutParams
        layoutParams.height = layoutParams.height + (0..50).random()
        holder.iv_icon.layoutParams = layoutParams
        holder.tv_time.background.alpha = 70

        holder.iv_icon.setOnClickListener(View.OnClickListener {
            onItemClickListener!!.onItemClick(position)
        })
    }


    class ViewHolder: RecyclerView.ViewHolder{

        var iv_icon: ImageView
        var tv_time: TextView

        constructor(itemView: View): super(itemView){
            iv_icon = itemView.findViewById(R.id.iv_icon)
            tv_time = itemView.findViewById(R.id.tv_time)
        }

    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

}