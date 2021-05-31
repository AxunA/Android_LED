package com.zyou.led.db;

import com.zyou.led.entity.ModelEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface ModelDao {

    @Query("SELECT * FROM show_mode")
    List<ModelEntity> getAll();

    @Query("SELECT ")
    ModelEntity getCurrentSelectMode();

    boolean setSelectMode(int position);

}
