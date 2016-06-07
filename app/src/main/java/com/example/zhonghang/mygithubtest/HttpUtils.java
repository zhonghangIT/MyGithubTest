package com.example.zhonghang.mygithubtest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by sqq on 16/6/3.
 */
public class HttpUtils {

    public static boolean isNetWorkConn(Context context){
        ConnectivityManager manager= (ConnectivityManager) context.
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info=manager.getActiveNetworkInfo();
        if(info!=null){
            return info.isConnected();
        }else{
            return false;
        }
    }

    public static byte[] getHttpResult(String path){
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        try {
            URL url=new URL(path);
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode=conn.getResponseCode();
            if(responseCode==200){
                InputStream inputStream=conn.getInputStream();
                int temp=0;
                byte[] buff=new byte[1024];
                while((temp=inputStream.read(buff))!=-1){
                    outputStream.write(buff,0,temp);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

}
