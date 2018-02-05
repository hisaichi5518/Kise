package com.github.hisaichi5518.kise.unittype;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewStub;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class ViewUnit2 implements UnitType {

    private final ViewStub trueViewStub;

    private final ViewStub falseViewStub;

    protected String firebaseRemoteConfigKey = getClass().getSimpleName();

    public ViewUnit2(@NonNull ViewStub trueViewStub, @NonNull ViewStub falseViewStub) {
        this.trueViewStub = trueViewStub;
        this.falseViewStub = falseViewStub;
    }

    protected void trueAction(View inflated) throws Exception {
    }

    protected void falseAction(View inflated) {
    }

    public void invoke() {
        final FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
        if (config != null && config.getBoolean(firebaseRemoteConfigKey)) {
            try {
                trueAction(trueViewStub.inflate());
            } catch (Exception e) {
                falseAction(falseViewStub.inflate());
            }
        } else {
            falseAction(falseViewStub.inflate());
        }
    }
}
