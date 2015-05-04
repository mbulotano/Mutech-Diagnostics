package com.mutech.mutechdiagnostic.Model;

import android.app.Application;
import android.content.Context;

/*
 * Created by ZawMai on 5/2/2015.
 */
public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate(){
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }
}
