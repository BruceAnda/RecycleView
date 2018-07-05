package com.bawei.recycleview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bawei.recycleview.R;
import com.bawei.recycleview.holder.WaterFallHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WaterFallAdapter extends RecyclerView.Adapter<WaterFallHolder> {

    private Context context;
    private List<String> datas;
    private List<Integer> heightList;

    public WaterFallAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;

        heightList = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            heightList.add((int) (Math.random() * 100 + 200));
        }
    }

    @NonNull
    @Override
    public WaterFallHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WaterFallHolder(LayoutInflater.from(context).inflate(R.layout.water_fall_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WaterFallHolder holder, int position) {
        ViewGroup.LayoutParams params = holder.textView.getLayoutParams();
        params.height = heightList.get(position);

        holder.textView.setBackgroundColor(Color.rgb((int) (Math.random() * 100 + 155), (int) (Math.random() * 100 + 155), (int) (Math.random() * 100 + 155)));
        holder.textView.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
