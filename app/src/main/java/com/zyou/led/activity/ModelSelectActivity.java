package com.zyou.led.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.zyou.led.R;
import com.zyou.led.adapter.ModelItemAdapter;
import com.zyou.led.comm.Constrats;
import com.zyou.led.databinding.ActivityModelSelectBinding;
import com.zyou.led.entity.ModelEntity;
import com.zyou.led.util.SharePreUtil;
import com.zyou.led.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;

public class ModelSelectActivity extends BaseActivity<ActivityModelSelectBinding> implements ModelItemAdapter.OnItemSelectListener{

    private List<ModelEntity> mList;
    private ModelItemAdapter mAdapter;
    private int mDefaultSelectPosition;
    private int mSelectPosition;

    public static final String INTENT_KEY_CONTENT="intent_key_content";

    public static void open(Context context, String content){
        Intent intent=new Intent(context,ModelSelectActivity.class);
        intent.putExtra(INTENT_KEY_CONTENT,content);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }

    private void initViews(){
        initListData();
        mAdapter =new ModelItemAdapter(this,mList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mBinding.rvModel.setLayoutManager(linearLayoutManager);
        mBinding.rvModel.setNestedScrollingEnabled(true);
        mBinding.rvModel.setAdapter(mAdapter);
    }

    private void initListData(){
        mList=new ArrayList<>();
        mList.addAll(getModelDao().getAll());

        mDefaultSelectPosition= SharePreUtil.getInt(this,Constrats.SHARE_PRE_KEY_SELECT_POSITION);
        mList.get(mDefaultSelectPosition).setSelect(true);
    }

    public void onClick(View view) {
        if(view==mBinding.btnSelect){
            if(mSelectPosition!=mDefaultSelectPosition){
                SharePreUtil.saveInt(this,Constrats.SHARE_PRE_KEY_SELECT_POSITION,mSelectPosition);
            }
            String inputContent=getIntent().getStringExtra(INTENT_KEY_CONTENT);
            if(TextUtils.isEmpty(inputContent)){
                ToastUtil.show(this,R.string.input_can_not_be_empty);
                return;
            }
            ShowActivity.open(this,inputContent);
        }
    }

    @Override
    public void itemSelect(int position) {
        for (int i=0;i<mList.size();i++){
            mList.get(i).setSelect(false);
        }
        mList.get(position).setSelect(true);
        mAdapter.notifyDataSetChanged();
        mSelectPosition=position;
    }


}