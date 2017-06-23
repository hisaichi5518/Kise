package com.github.hisaichi5518.kise;

import android.support.annotation.XmlRes;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import static com.github.hisaichi5518.kise.Kise.Store.INSTANCE;

public class Kise {
    enum Store {
        INSTANCE;

        Kise kise;
    }

    public static void initialize(FirebaseRemoteConfigSettings settings, @XmlRes int resId) {
        INSTANCE.kise = new Kise();

        FirebaseRemoteConfig.getInstance().setConfigSettings(settings);
        FirebaseRemoteConfig.getInstance().setDefaults(resId);
    }

    public Kise getInstance() {
        if (INSTANCE.kise == null) {
            throw new IllegalStateException("Initialize method is not running.");
        }

        return INSTANCE.kise;
    }
}
