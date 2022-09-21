package com.example.testchaylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<ThucAn> thucAnArray;
    ThucAnAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listview);


        thucAnArray = new ArrayList<>();
        thucAnArray.add(new ThucAn("Bun","Bun Bo", R.drawable.bun));
        thucAnArray.add(new ThucAn("Chao","Chao trang", R.drawable.chao));
        thucAnArray.add(new ThucAn("Com","Com trang", R.drawable.com));
        adapter = new ThucAnAdapter(MainActivity.this, R.layout.layout_thucan, thucAnArray);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,DetailLayoutActivity.class);
                startActivity(intent);
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Thông Báo!");
                alertDialog.setMessage("Bạn có muốn xóa món ăn này?");
                int so = i;
                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        thucAnArray.remove(so);
                        adapter.notifyDataSetChanged();
                    }
                });
                alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alertDialog.show();
                return false;
            }
        });
    }
}