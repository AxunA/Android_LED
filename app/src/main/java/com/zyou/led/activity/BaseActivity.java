package com.zyou.led.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

public class BaseActivity<T extends ViewBinding> extends AppCompatActivity {

    protected final String TAG=this.getClass().getName();
    protected T mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Class cls = (Class) type.getActualTypeArguments()[0];
        try {
            Method inflate = cls.getDeclaredMethod("inflate", LayoutInflater.class);
            mBinding = (T) inflate.invoke(null, getLayoutInflater());
            setContentView(mBinding.getRoot());
        } catch (NoSuchMethodException | IllegalAccessException| InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
