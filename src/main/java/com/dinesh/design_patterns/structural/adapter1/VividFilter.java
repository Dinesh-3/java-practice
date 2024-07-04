package com.dinesh.design_patterns.structural.adapter1;

public class VividFilter implements Filter {
  @Override
  public void apply(Image image) {
    System.out.println("Applying Vivid Filter");
  }
}
