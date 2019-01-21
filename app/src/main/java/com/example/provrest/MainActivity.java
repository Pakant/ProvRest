package com.example.provrest;

import android.hardware.fingerprint.FingerprintManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.example.provrest.Util.RestUtilityAsyncTask;
import com.example.provrest.Util.RestUtilityVolley;

import java.util.Map;


public class MainActivity extends AppCompatActivity {

    ListView lista;
    Button rest;
    String url;
    private Map<String, String> params;

    public MainActivity(Map<String, String> params) {
        this.params = params;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rest = findViewById(R.id.rest);
        lista = findViewById(R.id.dynamic);
        url= "inserisci url";

        rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RestUtilityAsyncTask.get("Dipendenti", null);
                RestUtilityAsyncTask.post("Dipendenti",null);
                RestUtilityVolley.getVolley(MainActivity.this, url, params);
                RestUtilityVolley.postVolley(MainActivity.this, url, params);

            }

        });

    }
}


