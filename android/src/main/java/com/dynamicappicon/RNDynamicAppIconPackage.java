package com.dynamicappicon;

import androidx.annotation.NonNull;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;

import java.util.Collections;
import java.util.List;

public class RNDynamicAppIconPackage implements ReactPackage {
    @NonNull
    @Override
    public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactContext) {
        return Collections.<NativeModule>singletonList(new RNDynamicAppIconModule(reactContext));
    }
}