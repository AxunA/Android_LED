package com.zyou.led.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zyou.led.entity.ModelEntity;
import com.zyou.led.R;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ModelItemAdapter extends RecyclerView.Adapter<ModelItemAdapter.ViewHolder> {

    private List<ModelEntity> mList;
    private OnItemSelectListener mOnItemSelectListener;

    public ModelItemAdapter(Context context, List<ModelEntity> list, OnItemSelectListener onItemSelectListener){
        mList=list;
        mOnItemSelectListener=onItemSelectListener;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_model,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        ModelEntity entity=mList.get(position);
        holder.mRl.setBackgroundResource(entity.getBgColor());
        holder.mTv.setTextColor(entity.getTvColor());
        holder.mTv.setTextSize(entity.getTxSize());
        holder.mForeGroundIv.setVisibility(entity.isShowLedForeground()?View.VISIBLE:View.GONE);
        holder.mSelectV.setBackgroundResource(entity.isSelect()?R.drawable.bg_select_model_item:R.drawable.bg_no_select_model_item);

        holder.mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemSelectListener.itemSelect(position);
            }
        });
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private RelativeLayout mRl;
        private TextView mTv;
        private ImageView mForeGroundIv;
        private View mSelectV;

        ViewHolder(View itemView){
            super(itemView);
            setIsRecyclable(false);
            mRl=(RelativeLayout)itemView.findViewById(R.id.rl_bg);
            mTv =(TextView)itemView.findViewById(R.id.tv_item);
            mForeGroundIv=(ImageView) itemView.findViewById(R.id.iv_foreground);
            mSelectV=(View)itemView.findViewById(R.id.v_select);
        }
    }

    public static interface OnItemSelectListener {
        void itemSelect(int position);
    }
}
