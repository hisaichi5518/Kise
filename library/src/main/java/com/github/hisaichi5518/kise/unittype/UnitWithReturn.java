package com.github.hisaichi5518.kise.unittype;


import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public abstract class UnitWithReturn<ReturnValue> implements UnitType {
    protected abstract ReturnValue customAction() throws Exception;

    protected abstract ReturnValue defaultAction();

    public ReturnValue invoke() {
        final FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
        if (config.getBoolean(key())) {
            try {
                return customAction();
            } catch (Exception e) {
                return defaultAction();
            }
        } else {
            return defaultAction();
        }
    }

    private String key() {
        return this.getClass().getSimpleName();
    }
}
