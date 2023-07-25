package com.zhaoyao.app

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val textdemo1List = ArrayList<news1>()     //没图
    private val textimagedemo1List = ArrayList<news2>()//有图

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.v("ZhaoYaoApp", "Main activity onCreate ; time = ${System.currentTimeMillis()}")

        //recyclerview的写法
        initText1()//初始化数据
        val recyclerView1 = findViewById<RecyclerView>(R.id.rv1)
        val layoutManager1 = LinearLayoutManager(this)
        recyclerView1.layoutManager = layoutManager1
        val adpter1 = rvadapter1(textdemo1List)//上面
        recyclerView1.adapter = adpter1

        initText2()
        val recyclerView2 = findViewById<RecyclerView>(R.id.rv2)
        val layoutManager2 = LinearLayoutManager(this)
        recyclerView2.layoutManager = layoutManager2
        val adpter2 = rvadapter2(textimagedemo1List)//下面
        recyclerView2.adapter = adpter2
    }

    override fun onResume() {
        super.onResume()
        Log.v("ZhaoYaoApp", "Main activity onResume ; time = ${System.currentTimeMillis()}")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ZhaoYaoApp", "Main activity onPause ; time = ${System.currentTimeMillis()}")
    }

    fun showToast(view: View) {
        Toast.makeText(this, "Hello World!", Toast.LENGTH_SHORT).show()
    }

    private fun initText1(){
        repeat(1){
            textdemo1List.add(news1("这些重大问题，习近平的回答掷地有声","置顶","新华社新媒体"))
            textdemo1List.add(news1("习近平会见”元老会“代表团","置顶", "央视网新闻"))
        }


    }
    private fun initText2(){
        repeat(1){
            textimagedemo1List.add(news2("美媒：五角大楼盯上谷歌在华AI中心 谷歌忙安抚","热点","热点消息", R.drawable.news_pic1))
            textimagedemo1List.add(news2("蔡英文财产曝光：存款5406万 名下拥有6笔不动产","热点","热点消息", R.drawable.news_pic2))
        }
    }
}

class news1(val text1:String, val text2:String, val text3:String)
class news2(val text1:String, val text2:String, val text3:String, val imageId: Int)