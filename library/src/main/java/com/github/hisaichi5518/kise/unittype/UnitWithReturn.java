package com.github.hisaichi5518.kise.unittype;


import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public abstract class UnitWithReturn<ReturnValue> implements UnitType {

    protected String firebaseRemoteConfigKey = getClass().getSimpleName();

    protected abstract ReturnValue customAction() throws Exception;

    protected abstract ReturnValue defaultAction();

    public ReturnValue invoke() {
        final FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
        if (config.getBoolean(firebaseRemoteConfigKey)) {
            try {
                return customAction();
            } catch (Exception e) {
                return defaultAction();
            }
        } else {
            return defaultAction();
        }
    }
}
