package com.example.suratlea.Login;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.lang.ref.ReferenceQueue;

public class VolleyConnection {
    private static VolleyConnection vIntance;
    private RequestQueue requestQueue;
    private static Context vCtx;

    private VolleyConnection(Context context){
        vCtx = context;
        requestQueue = getRequestQueue();
    }

    private RequestQueue getRequestQueue(){
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(vCtx.getApplicationContext());
        }
        return requestQueue;
    }
    public static synchronized VolleyConnection getInstance(Context context){
        if (vIntance == null){
            vIntance = new VolleyConnection(context);
        }
        return vIntance;
    }
    public<T> void addToRequestQue (Request<T> request){
        getRequestQueue().add(request);
    }
}
