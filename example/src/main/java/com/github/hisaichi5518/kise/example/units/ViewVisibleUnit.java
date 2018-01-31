package com.github.hisaichi5518.kise.example.units;

import android.support.annotation.NonNull;
import android.view.View;

import com.github.hisaichi5518.kise.unittype.Unit;

public class ViewVisibleUnit extends Unit {
    private final View view;

    public ViewVisibleUnit(@NonNull View view) {
        this.view = view;
    }

    @Override
    protected void trueAction() throws Exception {
        this.view.setVisibility(View.VISIBLE);
    }

    @Override
    protected void falseAction() {
        this.view.setVisibility(View.GONE);
    }
}
