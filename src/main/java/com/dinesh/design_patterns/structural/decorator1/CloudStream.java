package com.dinesh.design_patterns.structural.decorator1;

public class CloudStream implements Stream {
  public void write(String data) {
    System.out.println("Cloud Storing... " + data);
  }
}
