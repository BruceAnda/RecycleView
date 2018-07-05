package com.bawei.recycleview.holder;

import android.view.View;
import android.widget.TextView;

import com.bawei.recycleview.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TextHolder extends RecyclerView.ViewHolder {

    public TextView textView;

    public TextHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text_view);
    }
}
