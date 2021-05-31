package com.zyou.led.db;

import android.content.Context;

import com.zyou.led.comm.Constrats;
import androidx.room.Room;

public class DbUtil {

    private static DbUtil INSTANCE;
    private AppDatabase mAppDatabase;

    public static DbUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (DbUtil.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DbUtil();
                }
            }
        }
        return INSTANCE;
    }

    public ModelDao getModeDao(Context context){
        if(mAppDatabase==null) mAppDatabase= Room.databaseBuilder(context,AppDatabase.class, Constrats.DB_NAME).build();
        return mAppDatabase.modelDao();
    }
}
