package com.github.hisaichi5518.kise;


import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public abstract class Unit<ActionParam> {

    abstract void customAction(ActionParam actionParam) throws Exception;

    abstract void defaultAction(ActionParam actionParam);

    public void invoke(final ActionParam actionParam) {
        final FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
        if (config.getBoolean(key())) {
            try {
                customAction(actionParam);
            } catch (Exception e) {
                defaultAction(actionParam);
            }
        } else {
            defaultAction(actionParam);
        }
    }

    private String key() {
        return this.getClass().getSimpleName();
    }
}