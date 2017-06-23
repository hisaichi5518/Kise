package com.github.hisaichi5518.kise;


public abstract class Unit<T> implements UnitActions<T> {
    public void invoke(T actionParam) {

    }

    protected String key() {
        return this.getClass().getSimpleName();
    }
}
