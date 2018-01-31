package com.github.hisaichi5518.kise.unittype;


import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public abstract class Unit implements UnitType {

    protected String firebaseRemoteConfigKey = getClass().getSimpleName();

    protected abstract void trueAction() throws Exception;

    protected abstract void falseAction();

    public void invoke() {
        final FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
        if (config.getBoolean(firebaseRemoteConfigKey)) {
            try {
                trueAction();
            } catch (Exception e) {
                falseAction();
            }
        } else {
            falseAction();
        }
    }
}
