package com.zyou.led.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

    public static void show(Context context,String content){
        Toast.makeText(context,content,Toast.LENGTH_SHORT).show();
    }

    public static void show(Context context,int res){
        Toast.makeText(context,res,Toast.LENGTH_SHORT).show();
    }
}
