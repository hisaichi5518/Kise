package com.github.hisaichi5518.kise;


import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public abstract class Unit<ActionParam> implements UnitActions<ActionParam> {

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
        // TODO: Callback methods does not execute if Google play service is out date.
    }

    private String key() {
        return this.getClass().getSimpleName();
    }
}