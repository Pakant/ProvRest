package com.example.provrest.Util;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RestUtilityVolley {
    static RequestQueue mQueue;


    public static void getVolley(Context context) {
        mQueue = Volley.newRequestQueue(context);
        String url = "https://provrest-7684c.firebaseio.com/Dipendenti.json";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("Dipendenti");
                    String[] list = new String[jsonArray.length()];
                    for (int i = 0; i < jsonArray.length(); i++) {
                        list[i] = jsonArray.getString(i) + "\n";
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.i("restVolley","funzionaGet");
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Errore", "Error :" + error.toString());
            }
        });
        mQueue.add(request);
    }
    public static void postVolley(Context context) {
        String url = "https://provrest-7684c.firebaseio.com/Dipendenti.json";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("Dipendenti");
                    String[] list = new String[jsonArray.length()];
                    for (int i = 0; i < jsonArray.length(); i++) {
                        list[i] = jsonArray.getString(i) + "\n";
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.i("restVolley","funzionaPost");
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Errore", "Error :" + error.toString());
            }
        });
        mQueue.add(request);
    }
}
