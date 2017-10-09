package com.example.praful.restfulapiclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String listItem[] = {"Login","Create User Account","Department  Details"};
        ListView lvMain = (ListView) findViewById(R.id.lv_main);
        lvMain.setAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, listItem));

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if (arg2==0){
                    Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(i);
                }
                else if (arg2 == 1){
                    Intent i = new Intent(getApplicationContext(),  CreateUserActivity.class);
                    startActivity(i);
                }
                else if (arg2 == 2){
                    Intent i = new Intent(getApplicationContext(),  DeptActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
