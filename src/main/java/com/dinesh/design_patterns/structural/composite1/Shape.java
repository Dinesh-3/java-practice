package com.dinesh.design_patterns.structural.composite1;

public class Shape implements Component {

  private final int index;

  public Shape(int i) {
    this.index = i;
  }

  @Override
  public void render() {
    System.out.println("Rendering Shape: " + index);
  }

  @Override
  public void move() {
    System.out.println("Moving Shape: " + index);
  }
}
