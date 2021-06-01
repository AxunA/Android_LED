package com.zyou.led.comm;

import android.app.Application;

import com.zyou.led.R;
import com.zyou.led.db.DbUtil;
import com.zyou.led.db.ModelDao;
import com.zyou.led.entity.ModelEntity;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initDb();
    }

    private void initDb(){
        new Thread(){
            @Override
            public void run() {
                ModelDao modelDao=DbUtil.getInstance().getModeDao(getApplicationContext());
                if(modelDao.getAll().size()==0){ //表示需要初始化
                    List<ModelEntity>  mList=new ArrayList<>();
                    mList.add(new ModelEntity(false, R.color.white,R.color.black,80,false));
                    mList.add(new ModelEntity(false, R.color.black,R.color.white,80,false));
                    mList.add(new ModelEntity(false, R.color.black,R.color.red,80,false));
                    mList.add(new ModelEntity(false, R.color.white,R.color.red,80,false));
                    modelDao.insertData(mList);
                }
            }
        }.start();
    }
}
