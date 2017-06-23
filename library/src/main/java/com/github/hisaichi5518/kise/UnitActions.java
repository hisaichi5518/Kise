package com.github.hisaichi5518.kise;

public interface UnitActions<ActionParam> {
    void customAction(ActionParam actionParam) throws Exception;

    void defaultAction(ActionParam actionParam);
}
