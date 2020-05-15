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

class MustPrepareAdapter(var context: Context, var itemList: List<String>): RecyclerView.Adapter<MustPrepareAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_must_prepare, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rb_score.numStars = (0..5).random()
    }


    class ViewHolder: RecyclerView.ViewHolder{

        var siv_icon: ShapeImageView
        var tv_title: TextView
        var rb_score: RatingBar
        var tv_desc: TextView
        var tv_go_in: TextView

        constructor(itemView: View): super(itemView){
            siv_icon = itemView.findViewById(R.id.siv_icon)
            tv_title = itemView.findViewById(R.id.tv_title)
            rb_score = itemView.findViewById(R.id.rb_score)
            tv_desc = itemView.findViewById(R.id.tv_desc)
            tv_go_in = itemView.findViewById(R.id.tv_go_in)
        }

    }

}