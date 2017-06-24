package com.github.hisaichi5518.kise.unittype;


import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public abstract class Unit {

    protected abstract void customAction() throws Exception;

    protected abstract void defaultAction();

    public void invoke() {
        final FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
        if (config.getBoolean(key())) {
            try {
                customAction();
            } catch (Exception e) {
                defaultAction();
            }
        } else {
            defaultAction();
        }
    }

    private String key() {
        return this.getClass().getSimpleName();
    }
}
