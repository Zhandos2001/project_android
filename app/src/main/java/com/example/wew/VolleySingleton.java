package com.example.wew;

import android.app.Activity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class VolleySingleton {

    private RequestQueue requestQueue;
    private static VolleySingleton mInstance;

    private VolleySingleton(Activity activity){
        requestQueue = Volley.newRequestQueue(activity.getApplicationContext());
    }

    public static synchronized VolleySingleton getmInstance(Activity activity){

        if (mInstance == null){
            mInstance = new VolleySingleton(activity);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue(){return requestQueue;}
}