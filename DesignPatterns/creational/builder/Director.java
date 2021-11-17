package DesignPatterns.creational.builder;

public class Director {
     Builder builder;

    public Director(Builder concreteBuilder) {
        this.builder = concreteBuilder;
    }

    public void startHomeConstruction() {
        this.builder.buildFloors();
        this.builder.buildWalls();
        this.builder.buildSteps();
        this.builder.buildTerrace();
    }

    public Home getComplexObjectOfHome() {
        return this.builder.getProduct();
    }
}
