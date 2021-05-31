package com.zyou.led.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.zyou.led.base.BaseActivity;
import com.zyou.led.databinding.ActivityShowBinding;

public class ShowActivity extends BaseActivity<ActivityShowBinding> {

    public static final String INTENT_KEY_CONTENT="intent_key_content";

    public static void open(Context context, String content){
        Intent intent=new Intent(context,ShowActivity.class);
        intent.putExtra(INTENT_KEY_CONTENT,content);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }

    private void initViews(){
        String content=getIntent().getStringExtra(INTENT_KEY_CONTENT);
        Log.d(TAG,"content:"+content);
        mBinding.mtv.setText(content);
    }

}