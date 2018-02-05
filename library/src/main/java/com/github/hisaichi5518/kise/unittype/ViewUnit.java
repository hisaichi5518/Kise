package com.github.hisaichi5518.kise.unittype;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewStub;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class ViewUnit implements UnitType {

    private final ViewStub viewStub;

    protected String firebaseRemoteConfigKey = getClass().getSimpleName();

    public ViewUnit(@NonNull ViewStub viewStub) {
        this.viewStub = viewStub;
    }

    protected void trueAction(View inflated) throws Exception {
    }

    protected void falseAction() {
    }

    public void invoke() {
        final FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
        if (config != null && config.getBoolean(firebaseRemoteConfigKey)) {
            try {
                trueAction(viewStub.inflate());
            } catch (Exception e) {
                falseAction();
            }
        } else {
            falseAction();
        }
    }
}
