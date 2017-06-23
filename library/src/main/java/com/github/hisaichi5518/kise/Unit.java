package com.github.hisaichi5518.kise;


import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public abstract class Unit<ActionParam> implements UnitActions<ActionParam> {
    public void invoke(ActionParam actionParam) {
        FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
        config.fetch(0).

    }

    protected String key() {
        return this.getClass().getSimpleName();
    }
}