package com.example.zhonghang.mygithubtest.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.zhonghang.mygithubtest.MyPagerImgAsyncTask;

import java.util.List;

/**
 * Created by zhonghang on 16/6/7.
 */

public class MyPagerAdapter extends PagerAdapter {
    private List<ImageView> views;

   public MyPagerAdapter(List<ImageView> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = views.get(position);
        container.addView(imageView);
        //图片的三级缓存
        MyPagerImgAsyncTask task=new MyPagerImgAsyncTask(imageView);
        task.execute("");
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }
}
