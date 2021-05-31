package com.zyou.led.db;

import com.zyou.led.entity.ModelEntity;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ModelEntity.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ModelDao modelDao();
}
