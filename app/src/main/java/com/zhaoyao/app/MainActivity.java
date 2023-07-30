package com.zhaoyao.app;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.zhaoyao.app.fragment.Frag_home;
import com.zhaoyao.app.fragment.Frag_user;
import com.zhaoyao.app.fragment.Frag_video;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {


    private ImageView home;
    private ImageView video;
    private ImageView user;
    private Bundle bundle;
    private String addnews;
    public static String username;
    public int frag;
    static public String news_data = "[" +
            "{" +
            "'title':'这些重大问题，习近平掷地有声'," +
            "'subtitle':'新华社新媒体'," +
            "'tip':'置顶'" +
            "}," +
            "{" +
            "'title':'习近平会见“元老会“代表团'," +
            "'subtitle':'央视网新闻'," +
            "'tip':'热点'" +
            "}," +
            "{" +
            "'title':'美媒：五角大楼顶上谷歌在华AI中心 谷歌忙安抚'," +
            "'subtitle':'参考消息'," +
            "'tip':'热点'," +
            "'pic':'/storage/emulated/0/Pictures/p1.png'" +
            "}," +
            "{" +
            "'title':'蔡英文财产曝光：存款5406万 名下拥6笔不动产'," +
            "'subtitle':'人民日报海外网'," +
            "'tip':'置顶'," +
            "'pic':'D:/Git-resource/homework-lesson3/homework3/app/src/main/res/drawable/p1.png'" +
            "}," +
            "{" +
            "'title':'美媒：五角大楼顶上谷歌在华AI中心 谷歌忙安抚'," +
            "'subtitle':'习近平会见“元老会“代表团'," +
            "'tip':'置顶'" +
            "}" +
            "]";
    static public String video_data = "[" +
            "{" +
            "'video_title':'疯狂动物城爆笑上映'," +
            "'username':'媒体+'," +
            "'video_img':'https://img2.baidu.com/it/u=3599238479,2998054692&fm=253&fmt=auto&app=120&f=JPEG?w=1281&h=800'," +
            "'video_src':'http://vjs.zencdn.net/v/oceans.mp4'" +
            "}," +
            "{" +
            "'video_title':'疯狂动物城爆笑上映'," +
            "'username':'媒体+'," +
            "'video_img':'https://img2.baidu.com/it/u=3599238479,2998054692&fm=253&fmt=auto&app=120&f=JPEG?w=1281&h=800'," +
            "'video_src':'http://vjs.zencdn.net/v/oceans.mp4'" +
            "}," +
            "{" +
            "'video_title':'疯狂动物城爆笑上映'," +
            "'username':'媒体+'," +
            "'video_img':'https://img2.baidu.com/it/u=3599238479,2998054692&fm=253&fmt=auto&app=120&f=JPEG?w=1281&h=800'," +
            "'video_src':'http://vjs.zencdn.net/v/oceans.mp4'" +
            "}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bundle = this.getIntent().getExtras();

        home = findViewById(R.id.home);
        video = findViewById(R.id.video);
        user = findViewById(R.id.user);
        turnFrag(home);

        if (bundle != null) {
            if (bundle.getInt("flag") == 1) {
                addnews = "{'title':'" + bundle.getString("title") + "'," +
                        "'subtitle':'" + bundle.getString("subtitle") + "'," +
                        "'tip':'" + bundle.getString("tip") + "'";
                if (bundle.getString("pic") != null)
                    addnews += ",'pic':'" + bundle.getString("pic") + "'},";
                else
                    addnews += "},";
                StringBuilder s = new StringBuilder(news_data);
                s.insert(1, addnews);
                news_data = s.toString();

                //写入文件
                //获取准确的路径,context.getPackageName()得到包名
                File dir = new File("data/data/" + this.getPackageName());
                //如果文件夹不存在，则创建指定的文件
                if (!dir.exists() || !dir.isDirectory()) {
                    dir.mkdir();
                }
                //文件声明
                File file = new File(dir, "news.txt");
                //输入流
                InputStream inputStream = null;
                //输出流
                OutputStream outputStream = null;
                //若不存在，通过IO流的方式，将assets目录下的数据库文件，写入到项目模拟手机中，当开启模拟
                //器时，会将数据库文件写入到模拟手机的内存中
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    //创建文件
                    file.createNewFile();
                    //加载文件
                    inputStream = new ByteArrayInputStream(news_data.getBytes());
                    //输出到文件
                    outputStream = new FileOutputStream(file);

                    byte[] buffer = new byte[1024];
                    int len;
                    //按字节写入
                    while ((len = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, len);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    //关闭资源
                    if (outputStream != null) {

                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }


            } else if (bundle.getInt("flag") == 2) {
                turnFrag(video);
            } else if (bundle.getInt("flag") == 3) {
                turnFrag(user);
            }
        }

        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                turnFrag(view);
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                turnFrag(view);
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                turnFrag(view);
            }
        });

    }


    public void turnFrag(View v) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Frag_home f1 = new Frag_home();
        Frag_video f2 = new Frag_video();
        Frag_user f3 = new Frag_user();
        switch (v.getId()) {
            case R.id.home:
                if (frag != 1) {
                    ft.replace(R.id.frag, f1);
                    frag = 1;
                }
                break;
            case R.id.video:
                if (frag != 2) {
                    ft.replace(R.id.frag, f2);
                    frag = 2;
                }
                break;
            case R.id.user:
                if (frag != 3) {
                    ft.replace(R.id.frag, f3);
                    frag = 3;
                }
                break;
        }
        ft.commit();
    }


}

