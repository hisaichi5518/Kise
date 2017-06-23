package com.github.hisaichi5518.kise.example.units;

import android.view.View;

import com.github.hisaichi5518.kise.Unit;

public class ViewVisibleUnit extends Unit<View> {
    @Override
    public void customAction(View view) throws Exception {
        view.setVisibility(View.VISIBLE);
    }

    @Override
    public void defaultAction(View view) {
        view.setVisibility(View.GONE);
    }
}
