package com.example.zhonghang.mygithubtest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

/**
 * Created by zhonghang on 16/6/7.
 */

public class MyPagerImgAsyncTask extends AsyncTask<String, Integer, Bitmap> {
    private ImageView imageView;

    public MyPagerImgAsyncTask(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        //xiazai
          byte[] data=  HttpUtils.getHttpResult("http://img1.imgtn.bdimg.com/it/u=3772608690,3716302673&fm=21&gp=0.jpg");
        Bitmap bitmap= BitmapFactory.decodeByteArray(data,0,data.length);
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);
    }
}
