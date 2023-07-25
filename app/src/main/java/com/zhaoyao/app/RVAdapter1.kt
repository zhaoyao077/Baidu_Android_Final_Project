package com.zhaoyao.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RVAdapter1(val textList: List<NewsText1>) : RecyclerView.Adapter<RVAdapter1.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text1_demo1: TextView = view.findViewById(R.id.list_tv2)
        val text2_demo1: TextView = view.findViewById(R.id.list_tv3)
        val text3_demo1: TextView = view.findViewById(R.id.list_tv4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item1, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val text_demo1 = textList[position]
        holder.text1_demo1.text = text_demo1.text1
        holder.text2_demo1.text = text_demo1.text2
        holder.text3_demo1.text = text_demo1.text3
    }

    override fun getItemCount() = textList.size
}