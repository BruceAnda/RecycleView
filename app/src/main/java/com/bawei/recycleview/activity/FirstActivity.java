package com.bawei.recycleview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.bawei.recycleview.R;
import com.bawei.recycleview.adapter.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> list;
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        recyclerView = findViewById(R.id.recycler_view);
        list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add("孙悟空" + i);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new SimpleAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }

    public void listView(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter.notifyDataSetChanged();
    }

    public void gridView(View view) {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        adapter.notifyDataSetChanged();
    }

    public void singleLine(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapter.notifyDataSetChanged();
    }

    public void mutipleLine(View view) {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3, OrientationHelper.HORIZONTAL, false));
        adapter.notifyDataSetChanged();
    }
}
