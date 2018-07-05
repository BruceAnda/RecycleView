package com.bawei.recycleview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.bawei.recycleview.R;
import com.bawei.recycleview.adapter.WaterFallAdapter;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private List<String> datas;
    private RecyclerView recyclerView;
    private WaterFallAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView = findViewById(R.id.recycler_view);

        datas = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            datas.add("孙大圣：" + i);
        }

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new WaterFallAdapter(this, datas);
        recyclerView.setAdapter(adapter);
    }

    public void add(View view) {
        datas.add(5, "猪八戒");
//        adapter.notifyDataSetChanged();
        adapter.notifyItemInserted(5);
    }

    public void delete(View view) {
        datas.remove(5);
//        adapter.notifyDataSetChanged();
        adapter.notifyItemRemoved(5);
    }

}
