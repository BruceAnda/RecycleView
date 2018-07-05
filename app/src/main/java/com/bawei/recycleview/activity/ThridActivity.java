package com.bawei.recycleview.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.bawei.recycleview.R;
import com.bawei.recycleview.adapter.MoreItemAdapter;
import com.bawei.recycleview.listener.MyItemTouchListener;
import com.bawei.recycleview.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class ThridActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> datas;
    private MoreItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thrid);

        recyclerView = findViewById(R.id.recycler_view);

        datas = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            datas.add("孙悟空" + i);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.list_line));
        recyclerView.addItemDecoration(itemDecoration);

        adapter = new MoreItemAdapter(this, datas);
        recyclerView.setAdapter(adapter);

        adapter.setListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int postion) {
                Toast.makeText(ThridActivity.this, "点击了：" + postion, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(int postion) {
                Toast.makeText(ThridActivity.this, "长按了：" + postion, Toast.LENGTH_SHORT).show();
            }
        });

        ItemTouchHelper helper = new ItemTouchHelper(new MyItemTouchListener(adapter));
        helper.attachToRecyclerView(recyclerView);
    }
}
