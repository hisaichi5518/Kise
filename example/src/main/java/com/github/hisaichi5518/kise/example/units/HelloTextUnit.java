package com.github.hisaichi5518.kise.example.units;


import android.support.annotation.NonNull;

import com.github.hisaichi5518.kise.unittype.UnitWithReturn;

public class HelloTextUnit extends UnitWithReturn<String> {
    @Override
    @NonNull
    protected String customAction() throws Exception {
        return "Hi!";
    }

    @Override
    @NonNull
    protected String defaultAction() {
        return "Hello!";
    }
}
