package DesignPatterns.creational.builder;

public interface Builder {
    void buildFloors();

    void buildWalls();

    void buildSteps();

    void buildTerrace();

    Home getProduct();
}
