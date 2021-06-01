package com.zyou.led.db;

import com.zyou.led.entity.ModelEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ModelDao {

    @Query("SELECT * FROM table_model")
    List<ModelEntity> getAll();

    @Query("SELECT * FROM table_model WHERE is_select IS 1 ")
    ModelEntity getCurrentSelectMode();

//    @Insert("INSERT ")
//    boolean setSelectMode(int position);

}
