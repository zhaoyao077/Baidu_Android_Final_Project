package com.zhaoyao.app

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zhaoyao.app.fragment.Home
import com.zhaoyao.app.fragment.User
import com.zhaoyao.app.fragment.Video

class MainActivity : AppCompatActivity() {
    private val textList1 = ArrayList<NewsText1>()
    private val textList2 = ArrayList<NewsText2>()

    private val delay: Long = 2000
    private lateinit var progressBar: ProgressBar

    private var home: ImageView? = null
    private var video: ImageView? = null
    private var user: ImageView? = null
    private var bundle: Bundle? = null
    var frag = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bundle = this.intent.extras

        Log.v("ZhaoYaoApp", "Main activity onCreate ; time = ${System.currentTimeMillis()}")

        //初始化Fragment
        home = findViewById(R.id.home)
        video = findViewById(R.id.video)
        user = findViewById(R.id.user)
        changeFrag(home as View)

        //初始化新闻列表
        addRecycleView()

        //展示天气图标渐显效果
        showValueAnim()
    }

    private fun changeFrag(v: View) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        val f1 = Home()
        val f2 = Video()
        val f3 = User()
        when (v.id) {
            R.id.home -> if (frag != 1) {
                ft.replace(R.id.frag, f1)
                frag = 1
            }

            R.id.video -> if (frag != 2) {
                ft.replace(R.id.frag, f2)
                frag = 2
            }

            R.id.user -> if (frag != 3) {
                ft.replace(R.id.frag, f3)
                frag = 3
            }
        }
        ft.commit()
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

    private fun addRecycleView() {
        initText1()
        val recyclerView1 = findViewById<RecyclerView>(R.id.rv1)
        val layoutManager1 = LinearLayoutManager(this)
        recyclerView1.layoutManager = layoutManager1
        val adapter1 = RVAdapter1(textList1)
        recyclerView1.adapter = adapter1

        initText2()
        val recyclerView2 = findViewById<RecyclerView>(R.id.rv2)
        val layoutManager2 = LinearLayoutManager(this)
        recyclerView2.layoutManager = layoutManager2
        val adapter2 = RVAdapter2(textList2)
        recyclerView2.adapter = adapter2
    }

    private fun initText1() {
        repeat(1) {
            textList1.add(NewsText1("这些重大问题，习近平的回答掷地有声", "置顶", "新华社新媒体"))
            textList1.add(NewsText1("习近平会见”元老会“代表团", "置顶", "央视网新闻"))
        }
    }

    private fun initText2() {
        repeat(4) {
            textList2.add(
                NewsText2(
                    "美媒：五角大楼盯上谷歌在华AI中心 谷歌忙安抚",
                    "热点",
                    "热点消息",
                    R.drawable.news_pic1
                )
            )
            textList2.add(
                NewsText2(
                    "蔡英文财产曝光：存款5406万 名下拥有6笔不动产",
                    "热点",
                    "热点消息",
                    R.drawable.news_pic2
                )
            )
        }
    }

    private fun showValueAnim() {
        val view = findViewById<TextView>(R.id.textView)
        val valueAnim = ValueAnimator.ofInt(0, 100)
        valueAnim?.duration = 50000L
        valueAnim?.interpolator = DecelerateInterpolator(10f)
        valueAnim?.addUpdateListener {
            val currentValue = it.animatedValue as Int
            view.alpha = currentValue / 100f //透明度渐增
        }

        valueAnim?.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator, isReverse: Boolean) {
            }

            override fun onAnimationEnd(animation: Animator) {
            }

            override fun onAnimationCancel(animation: Animator) {
            }

            override fun onAnimationRepeat(animation: Animator) {
            }

        })

        valueAnim?.start()
    }

    fun onTextViewClick(view: View) {
        // 显示 loading 界面
        progressBar = findViewById(R.id.progressBar1)
        progressBar.visibility = View.VISIBLE
        val linearLayout1 = findViewById<LinearLayout>(R.id.ll2)
        linearLayout1?.setBackgroundColor(Color.WHITE)

        // 延迟 300ms 后跳转到目标 Activity
        Handler(Looper.getMainLooper()).postDelayed({
            // 隐藏 loading 界面
            progressBar.visibility = View.GONE
            // 跳转到目标 Activity
            val intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
        }, delay)
    }
}