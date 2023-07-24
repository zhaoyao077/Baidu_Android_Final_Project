package com.zhaoyao.app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.v("ZhaoYaoApp", "Main activity onCreate ; time = ${System.currentTimeMillis()}")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ZhaoYaoApp", "Main activity onResume ; time = ${System.currentTimeMillis()}")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ZhaoYaoApp", "Main activity onPause ; time = ${System.currentTimeMillis()}")
    }
}