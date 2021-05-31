package com.zyou.led.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreUtil {

    private static final String SHAREDPREFERENCES_NAME="led_sharepreferences";

    private static SharedPreferences getShare(Context context){
        return context.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public static void saveInt(Context context,String key,int value){
        SharedPreferences.Editor edit= getShare(context).edit();
        edit.putInt(key, value);
        edit.apply();
    }

    public static void saveString(Context context,String key,String value){
        SharedPreferences.Editor edit= getShare(context).edit();
        edit.putString( key,value);
        edit.apply();
    }

    public static int getInt(Context context,String key){
        return getShare(context).getInt(key,0);
    }

    public static String getString(Context context,String key){
        return getShare(context).getString(key,"");
    }
}
