package com.example.zhonghang.mygithubtest;

import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.zhonghang.mygithubtest.adapter.MyPagerAdapter;
import com.example.zhonghang.mygithubtest.dao.NewsInfo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //加注释
    private ListView listView;
    private View header;
    private ViewPager viewPager;
    private List<ImageView> pagerImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        header = getLayoutInflater().inflate(R.layout.list_header, null);
        viewPager = (ViewPager) header.findViewById(R.id.viewpager);
        listView.addHeaderView(header);
        //加载viewpager网络数据
        pagerImg = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams
                    (new LinearLayoutCompat.LayoutParams
                            (ViewGroup.LayoutParams.MATCH_PARENT,
                                    ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setImageResource(R.mipmap.ic_launcher);
            pagerImg.add(imageView);
        }
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(pagerImg);
        viewPager.setAdapter(pagerAdapter);
        //加载list网络数据
        listView.setAdapter(new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,
                        new String[]{"aa", "bb", "cc", "dd", "ee"}));
    }


}
