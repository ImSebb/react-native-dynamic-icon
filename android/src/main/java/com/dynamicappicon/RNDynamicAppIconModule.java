package com.dynamicappicon;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;


class RNDynamicAppIconModule extends ReactContextBaseJavaModule {
    private static String REACT_CLASS = "RNDynamicAppIcon";

    RNDynamicAppIconModule(ReactApplicationContext reactContext){
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName(){
        return REACT_CLASS
    }

    @ReactMethod
    public void setAppIcon(String appIconName){
        this.switchToAlias(appIconName);
    }

    private static void switchToAlias(String aliasName) {
        Activity activity = getCurrentActivity();
        if(activity == null) return;
        PackageManager packageManager = activity.getPackageManager();

        ComponentName currentAlias = new ComponentName(activity, MainActivity.class);
        packageManager.setComponentEnabledSetting(
            currentAlias,
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        );

        ComponentName newAlias = new ComponentName(activity, aliasName);
        packageManager.setComponentEnabledSetting(
            newAlias,
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        );
    }
}
