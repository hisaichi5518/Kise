package com.github.hisaichi5518.kise;

public interface UnitActions<ACTION_PARAM> {
    void customAction(ACTION_PARAM actionParam);

    void defaultAction(ACTION_PARAM actionParam);
}
