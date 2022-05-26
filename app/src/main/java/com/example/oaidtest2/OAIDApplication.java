package com.example.oaidtest2;

import android.app.Application;

public class OAIDApplication extends Application{
    public static final String TAG = "OAIDApplication";
    @Override
    public void onCreate() {
        super.onCreate();
        MsaHelper.init(); // Step （3）SDK初始化操作
    }

}
