package com.bawei.recycleview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.recycleview.R;
import com.bawei.recycleview.holder.ImageLeftHolder;
import com.bawei.recycleview.holder.ImageRightHolder;
import com.bawei.recycleview.holder.TextHolder;
import com.bawei.recycleview.listener.MyItemMoveListener;
import com.bawei.recycleview.listener.OnItemClickListener;

import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoreItemAdapter extends RecyclerView.Adapter implements MyItemMoveListener {

    private Context context;
    private List<String> datas;
    private OnItemClickListener listener;
    public final int ITEM_TYPE_TEXT = 1;
    public final int ITEM_TYPE_IMAGE_LEFT = 2;
    public final int ITEM_TYPE_IMAGE_RIGHT = 3;

    public MoreItemAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case ITEM_TYPE_TEXT:
                holder = new TextHolder(LayoutInflater.from(context).inflate(R.layout.water_fall_holder, parent, false));
                break;
            case ITEM_TYPE_IMAGE_LEFT:
                holder = new ImageLeftHolder(LayoutInflater.from(context).inflate(R.layout.item_image_left, parent, false));
                break;
            case ITEM_TYPE_IMAGE_RIGHT:
                holder = new ImageRightHolder(LayoutInflater.from(context).inflate(R.layout.item_image_right, parent, false));
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        switch (getItemViewType(position)) {
            case ITEM_TYPE_TEXT:
                ((TextHolder) holder).textView.setText(datas.get(position));
                if (listener != null) {
                    ((TextHolder) holder).textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            listener.onItemClick(position);
                        }
                    });
                    ((TextHolder) holder).textView.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View view) {
                            listener.onItemLongClick(position);
                            return true;
                        }
                    });
                }
                break;
            case ITEM_TYPE_IMAGE_LEFT:
                ((ImageLeftHolder) holder).textView.setText(datas.get(position));
                break;
            case ITEM_TYPE_IMAGE_RIGHT:
                ((ImageRightHolder) holder).textView.setText(datas.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0) {
            return ITEM_TYPE_TEXT;
        } else if (position % 3 == 1) {
            return ITEM_TYPE_IMAGE_LEFT;
        } else {
            return ITEM_TYPE_IMAGE_RIGHT;
        }
    }

    @Override
    public void onMove(int currentPostion, int targetPostion) {
        Collections.swap(datas, currentPostion, targetPostion);
        notifyItemMoved(currentPostion, targetPostion);
    }
}
