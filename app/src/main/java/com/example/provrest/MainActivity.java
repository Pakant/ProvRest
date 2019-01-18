package com.example.provrest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.example.provrest.Util.RestUtilityAsyncTask;
import com.example.provrest.Util.RestUtilityVolley;


public class MainActivity extends AppCompatActivity {

    ListView lista;
    Button rest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rest = findViewById(R.id.rest);
        lista = findViewById(R.id.dynamic);

        rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RestUtilityAsyncTask.get("Dipendenti", null);
                RestUtilityAsyncTask.post("Dipendenti",null);
                RestUtilityVolley.getVolley(MainActivity.this);
                RestUtilityVolley.postVolley(MainActivity.this);

            }

        });

    }
}


