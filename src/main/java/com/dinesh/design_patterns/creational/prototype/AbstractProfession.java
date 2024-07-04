package com.dinesh.design_patterns.creational.prototype;

public abstract class AbstractProfession implements Cloneable{
    public abstract String profession();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
