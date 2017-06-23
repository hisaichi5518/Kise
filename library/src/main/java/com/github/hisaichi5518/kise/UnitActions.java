package com.github.hisaichi5518.kise;

public interface UnitActions<ACTION_PARAM> {
    void customAction(@android.support.annotation.Nullable ACTION_PARAM actionParam);

    void defaultAction(@android.support.annotation.Nullable ACTION_PARAM actionParam);
}
