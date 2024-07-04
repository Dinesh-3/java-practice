package com.dinesh.design_patterns.creational.builder;

public class HomeBuilder implements Builder{
    @Override
    public void buildFloors() {
        System.out.println("Building Floors");
    }

    @Override
    public void buildWalls() {
        System.out.println("Building Walls");

    }

    @Override
    public void buildSteps() {
        System.out.println("Building Steps");

    }

    @Override
    public void buildTerrace() {
        System.out.println("Building Terrace");

    }

    @Override
    public Home getProduct() {
        return new Home();
    }
}
