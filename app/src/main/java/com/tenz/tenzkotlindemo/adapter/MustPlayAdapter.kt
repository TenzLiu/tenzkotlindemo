package com.tenz.tenzkotlindemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tenz.tenzkotlindemo.R
import com.tenz.tenzkotlindemo.widget.imageview.ShapeImageView

class MustPlayAdapter(var context: Context, var itemList: List<String>): RecyclerView.Adapter<MustPlayAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_must_play, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }


    class ViewHolder: RecyclerView.ViewHolder{

        var siv_icon: ShapeImageView
        var tv_title: TextView
        var tv_desc: TextView
        var tv_go_in: TextView

        constructor(itemView: View): super(itemView){
            siv_icon = itemView.findViewById(R.id.siv_icon)
            tv_title = itemView.findViewById(R.id.tv_title)
            tv_desc = itemView.findViewById(R.id.tv_desc)
            tv_go_in = itemView.findViewById(R.id.tv_go_in)
        }

    }

}