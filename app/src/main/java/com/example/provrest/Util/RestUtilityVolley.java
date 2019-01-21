package com.example.provrest.Util;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RestUtilityVolley {

    static RequestQueue mQueue;


    public static void getVolley(Context contex, String url, Map<String, String> params) {

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
                Log.i("restVolley", "funzionaGet");
            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ERROR", "error => " + error.toString());
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                if (headers != null) {
                    Set<String> chiave = headers.keySet();
                    for (String x : chiave) {
                        String valore = headers.get(x);
                        headers.put(x, valore);
                    }
                    return headers;
                } else
                    return null;
            }
        };
        mQueue.add(request);
    }

    public static void postVolley(Context context, String url, final Map<String, String> params) {

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
                Log.i("restVolley", "funzionaGet");
            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ERROR", "error => " + error.toString());
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                if (headers != null) {
                    Set<String> chiave = headers.keySet();
                    for (String x : chiave) {
                        String valore = headers.get(x);
                        headers.put(x, valore);
                    }
                    return headers;
                } else
                    return null;
            }
        };
        mQueue.add(request);
    }
}
