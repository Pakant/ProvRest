package com.example.provrest.Util;


import android.util.Log;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

import static com.loopj.android.http.AsyncHttpClient.log;

public class RestUtilityAsyncTask {


    private static AsyncHttpClient client = new AsyncHttpClient();


    public static void get(String url, RequestParams params) {

        client.get(url, params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, final JSONObject response) {
                JSONArray array = response.names();
                String[] list = new String[array.length()];
                for (int i = 0; i < array.length(); i++) {
                    try {
                        list[i] = array.getString(i) + "\n";
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Log.i("GetRest", "okay rest");

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject
                    errorResponse) {
                log.i("errore", errorResponse.toString());
            }
        });
    }

    public static void post(String url, RequestParams params) {

        client.post(url,params, new JsonHttpResponseHandler(){

            public void onSuccess(int statusCode, Header[] headers, final JSONObject response) {
                JSONArray array = response.names();
                String[] list = new String[array.length()];
                for (int i = 0; i < array.length(); i++) {
                    try {
                        list[i] = array.getString(i) + "\n";
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Log.i("postRest", "Okay rest");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject
                    errorResponse) {
                log.i("errore", errorResponse.toString());
            }

        });
    }

}


