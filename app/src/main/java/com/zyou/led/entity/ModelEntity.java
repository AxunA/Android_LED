package com.zyou.led.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ModelEntity {

    @PrimaryKey
    private String id;
    @ColumnInfo(name = "is_select")
    private boolean isSelect;
    @ColumnInfo(name = "bg_color")
    private int bgColor;
    @ColumnInfo(name = "tv_color")
    private int tvColor;
    @ColumnInfo(name = "tx_size")
    private int txSize;
    @ColumnInfo(name = "is_show_led_foreground")
    private boolean isShowLedForeground;

    public ModelEntity(boolean isSelect, int bgColor, int tvColor, int txSize, boolean isShowLedForeground) {
        this.isSelect = isSelect;
        this.bgColor = bgColor;
        this.tvColor = tvColor;
        this.txSize = txSize;
        this.isShowLedForeground = isShowLedForeground;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public int getTvColor() {
        return tvColor;
    }

    public void setTvColor(int tvColor) {
        this.tvColor = tvColor;
    }

    public int getTxSize() {
        return txSize;
    }

    public void setTxSize(int txSize) {
        this.txSize = txSize;
    }

    public boolean isShowLedForeground() {
        return isShowLedForeground;
    }

    public void setShowLedForeground(boolean showLedForeground) {
        isShowLedForeground = showLedForeground;
    }
}
