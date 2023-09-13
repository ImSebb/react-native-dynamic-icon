package com.dynamicappicon;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;

class RNDynamicAppIconModule extends ReactContextBaseJavaModule {
    private static String REACT_CLASS = "RNDynamicAppIcon";

    RNDynamicAppIconModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void setAndroidAppIcon(String appIconName, ReadableArray aliasListArray) {
        List<String> aliasList = new ArrayList<>();
        for (int i = 0; i < aliasListArray.size(); i++) {
            aliasList.add(aliasListArray.getString(i));
        }
        this.switchToAlias(appIconName, getReactApplicationContext(), aliasList);
    }

    private static void switchToAlias(String aliasName, ReactApplicationContext reactContext, List<String> aliasList) {
        Activity activity = reactContext.getCurrentActivity();
        if (activity == null)
            return;
        PackageManager packageManager = activity.getPackageManager();

        for (String alias : aliasList) {
            if (!alias.equals(aliasName)) {
                ComponentName currentAlias = new ComponentName(activity, alias);
                packageManager.setComponentEnabledSetting(
                        currentAlias,
                        PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                        PackageManager.DONT_KILL_APP);
            }
        }

        ComponentName newAlias = new ComponentName(activity, aliasName);
        packageManager.setComponentEnabledSetting(
                newAlias,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }
}
