package com.zhaoyao.app;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhaoyao.app.bean.NewsBean;
import com.zhaoyao.app.bean.VideoBean;

import java.lang.reflect.Type;
import java.util.List;

public class JsonParse {
    private static JsonParse instance;

    private JsonParse() {
    }

    public static JsonParse getInstance() {
        if (instance == null) {
            instance = new JsonParse();

        }

        return instance;

    }

    public List<NewsBean> getNewsList(String json) {
        Gson gson = new Gson(); // 使用gson库解析JSON数据

        // 创建一个TypeToken的匿名子类对象，并调用对象的getType()方法

        Type listType = new TypeToken<List<NewsBean>>() {
        }.getType();

        // 把获取到的信息集合存到shopList中

        List<NewsBean> newsList = gson.fromJson(json.trim(), listType);
        return newsList;

    }

    public List<VideoBean> getVideoList(String json) {
        Gson gson = new Gson(); // 使用gson库解析JSON数据

        // 创建一个TypeToken的匿名子类对象，并调用对象的getType()方法

        Type listType = new TypeToken<List<VideoBean>>() {
        }.getType();

        // 把获取到的信息集合存到shopList中

        List<VideoBean> videoList = gson.fromJson(json.trim(), listType);
        System.out.print(videoList);
        return videoList;

    }

}
