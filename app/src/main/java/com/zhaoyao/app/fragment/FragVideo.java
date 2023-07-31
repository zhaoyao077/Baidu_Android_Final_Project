package com.zhaoyao.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhaoyao.app.adapter.VideoAdapter;
import com.zhaoyao.app.bean.VideoBean;
import com.zhaoyao.app.JsonParse;
import com.zhaoyao.app.MainActivity;
import com.zhaoyao.app.R;
import com.zhaoyao.app.SearchActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragVideo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragVideo extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List<VideoBean> videoList = new ArrayList<>();//定义视频信息列表

    private String mParam1;
    private String mParam2;

    public FragVideo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragVideo.
     */
    public static FragVideo newInstance(String param1, String param2) {
        FragVideo fragment = new FragVideo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_video, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        addVideo();//添加video信息
        RecyclerView recyclerView = getActivity().findViewById(R.id.video_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());//添加布局管理器
        recyclerView.setLayoutManager(layoutManager);//设置布局管理器
        VideoAdapter adapter = new VideoAdapter(videoList);
        recyclerView.setAdapter(adapter);

        //跳转搜索界面
        getActivity().findViewById(R.id.search2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addVideo() {
        videoList = JsonParse.getInstance().getVideoList(MainActivity.video_data);
    }
}