package com.github.hisaichi5518.kise.example.units;


import android.support.annotation.NonNull;

import com.github.hisaichi5518.kise.unittype.UnitWithReturn;

public class HelloTextUnit extends UnitWithReturn<String> {

    public HelloTextUnit() {
        this.firebaseRemoteConfigKey = "ViewVisibleUnit";
    }

    @Override
    @NonNull
    protected String trueAction() throws Exception {
        return "Hi!";
    }

    @Override
    @NonNull
    protected String falseAction() {
        return "Hello!";
    }
}
