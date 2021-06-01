package com.zyou.led.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zyou.led.databinding.ActivityShowBinding;
import com.zyou.led.entity.ModelEntity;

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
        ModelEntity entity=getModelDao().getCurrentSelectMode();
        mBinding.mtv.setBackgroundResource(entity.getBgColor());
        mBinding.mtv.setTextColor(entity.getTvColor());
        mBinding.mtv.setTextSize(entity.getTxSize());
        mBinding.ivForeground.setVisibility(entity.isShowLedForeground()? View.VISIBLE:View.GONE);
        mBinding.mtv.setText(getIntent().getStringExtra(INTENT_KEY_CONTENT));
    }

}