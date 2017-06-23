package com.github.hisaichi5518.kise.example;

import android.app.Application;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class ExampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();

        FirebaseRemoteConfig.getInstance().setConfigSettings(configSettings);
        FirebaseRemoteConfig.getInstance().setDefaults(R.xml.firebase_remote_config_defaults);
    }
}
