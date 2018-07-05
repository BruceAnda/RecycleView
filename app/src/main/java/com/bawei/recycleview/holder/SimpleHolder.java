package com.bawei.recycleview.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleHolder extends RecyclerView.ViewHolder {

    public TextView textView;

    public SimpleHolder(@NonNull View itemView) {
        super(itemView);

        textView = itemView.findViewById(android.R.id.text1);
    }
}
