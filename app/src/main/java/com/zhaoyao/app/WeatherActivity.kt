package com.zhaoyao.app

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class WeatherActivity : AppCompatActivity() {

    private val Weatherdemo1 = ArrayList<Weather>()//有图

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        //recyclerview的写法
        initText1()//初始化数据
        val recyclerView1 = findViewById<RecyclerView>(R.id.weatherrecyclerview1)
        val layoutManager1 = LinearLayoutManager(this)
        layoutManager1.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView1.layoutManager = layoutManager1
        val adpter1 = WeatherRecycleViewAdapter(Weatherdemo1)//上面
        recyclerView1.adapter = adpter1

    }

    //    fun onImageViewClick(view: View) {
//        // 在这里添加从当前 Activity 跳转到目标 Activity 的逻辑
//        val intent = Intent(this, MainActivity::class.java)
//        startActivity(intent)
//    }
    private val LOADING_DELAY: Long = 300 // 300ms
    private lateinit var progressBar: ProgressBar

    // 点击跳转事件处理方法
    fun onImageViewClick(view: View) {
        // 显示 loading 界面
        progressBar = findViewById(R.id.progressBar2)
        progressBar.visibility = View.VISIBLE
        val linearLayout1 = findViewById<LinearLayout>(R.id.ll5)
        linearLayout1?.setBackgroundColor(Color.WHITE)

        // 延迟 300ms 后跳转到目标 Activity
        Handler(Looper.getMainLooper()).postDelayed({
            // 隐藏 loading 界面
            progressBar.visibility = View.GONE
            //linearLayout1?.setBackgroundColor(Color.TRANSPARENT)

            // 跳转到目标 Activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, LOADING_DELAY) // 延迟 300ms
    }

    private fun initText1() {
        repeat(1) {
            Weatherdemo1.add(Weather("现在", R.drawable.weather_sunny))
            Weatherdemo1.add(Weather("1小时后", R.drawable.weather_cloudy))
            Weatherdemo1.add(Weather("2小时后", R.drawable.weather_cloudy))
            Weatherdemo1.add(Weather("3小时后", R.drawable.weather_rainy))
            Weatherdemo1.add(Weather("4小时后", R.drawable.weather_rainy))
            Weatherdemo1.add(Weather("5小时后", R.drawable.weather_cloudy))
            Weatherdemo1.add(Weather("6小时后", R.drawable.weather_cloudy))
            Weatherdemo1.add(Weather("7小时后", R.drawable.weather_sunny))
            Weatherdemo1.add(Weather("8小时后", R.drawable.weather_sunny))

        }


    }

}