package com.github.hisaichi5518.kise.example;

import android.app.Application;

import com.github.hisaichi5518.kise.Kise;
import com.google.firebase.FirebaseApp;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class ExampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseApp.initializeApp(this);
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();

        Kise.initialize(configSettings, R.xml.kise);
    }
}
