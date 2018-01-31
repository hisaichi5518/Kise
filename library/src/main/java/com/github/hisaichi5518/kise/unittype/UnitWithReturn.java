package com.github.hisaichi5518.kise.unittype;


import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public abstract class UnitWithReturn<ReturnValue> implements UnitType {

    protected String firebaseRemoteConfigKey = getClass().getSimpleName();

    protected abstract ReturnValue trueAction() throws Exception;

    protected abstract ReturnValue falseAction();

    public ReturnValue invoke() {
        final FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
        if (config != null && config.getBoolean(firebaseRemoteConfigKey)) {
            try {
                return trueAction();
            } catch (Exception e) {
                return falseAction();
            }
        } else {
            return falseAction();
        }
    }
}
