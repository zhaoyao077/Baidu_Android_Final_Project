package com.zhaoyao.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class rvadapter1(val textList: List<news1>):
    RecyclerView.Adapter<rvadapter1.ViewHolder>(){
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val text1_demo1: TextView = view.findViewById(R.id.list_tv2)
        val text2_demo1: TextView = view.findViewById(R.id.list_tv3)
        val text3_demo1: TextView = view.findViewById(R.id.list_tv4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item1,parent,false)
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

class rvadapter2(val textList2: List<news2>):
    RecyclerView.Adapter<rvadapter2.ViewHolder2>(){
    inner class ViewHolder2(view: View) : RecyclerView.ViewHolder(view){
        val text1_demo2: TextView = view.findViewById(R.id.list2_tv1)
        val text2_demo2: TextView = view.findViewById(R.id.list2_tv2)
        val text3_demo2: TextView = view.findViewById(R.id.list2_tv3)
        val text2image_demo2: ImageView = view.findViewById((R.id.list2_img1))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder2 {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item2,parent,false)
        return ViewHolder2(view)
    }

    override fun onBindViewHolder(holder: ViewHolder2, position: Int) {
        val text_demo2 = textList2[position]
        holder.text1_demo2.text = text_demo2.text1
        holder.text2_demo2.text = text_demo2.text2
        holder.text3_demo2.text = text_demo2.text3
        holder.text2image_demo2.setImageResource(text_demo2.imageId)
    }

    override fun getItemCount() = textList2.size
}