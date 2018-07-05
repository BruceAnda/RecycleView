package com.bawei.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bawei.recycleview.activity.FirstActivity;
import com.bawei.recycleview.activity.SecondActivity;
import com.bawei.recycleview.activity.ThridActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        list.add("布局管理器");
        list.add("瀑布流");
        list.add("多条目 下划线 条目点击");

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        enterActivity(MainActivity.this, FirstActivity.class);
                        break;
                    case 1:
                        enterActivity(MainActivity.this, SecondActivity.class);
                        break;
                    case 2:
                    case 3:
                    case 4:
                        enterActivity(MainActivity.this, ThridActivity.class);
                        break;
                }
            }
        });
    }

    private void enterActivity(Context context, Class clazz) {
        context.startActivity(new Intent(context, clazz));
    }
}
