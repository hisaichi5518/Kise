package com.github.hisaichi5518.kise.unittype;


import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public abstract class Unit implements UnitType {

    protected String firebaseRemoteConfigKey = this.getClass().getSimpleName();

    protected abstract void customAction() throws Exception;

    protected abstract void defaultAction();

    public void invoke() {
        final FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
        if (config.getBoolean(firebaseRemoteConfigKey)) {
            try {
                customAction();
            } catch (Exception e) {
                defaultAction();
            }
        } else {
            defaultAction();
        }
    }
}
