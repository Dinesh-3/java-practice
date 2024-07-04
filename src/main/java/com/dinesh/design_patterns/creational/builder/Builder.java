package com.dinesh.design_patterns.creational.builder;

public interface Builder {
    void buildFloors();

    void buildWalls();

    void buildSteps();

    void buildTerrace();

    Home getProduct();
}
