package com.zyou.led.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.zyou.led.R;
import com.zyou.led.databinding.ActivityMainBinding;
import com.zyou.led.util.ToastUtil;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onClick(View view) {
        String inputContent=mBinding.etInput.getText().toString();
        if(view==mBinding.btnStart){
            if(TextUtils.isEmpty(inputContent)){
                ToastUtil.show(this,R.string.input_can_not_be_empty);
                return;
            }
            ShowActivity.open(this,inputContent);
        }else if(view==mBinding.btnModelSelect){
            ModelSelectActivity.open(this,inputContent);
        }
    }
}