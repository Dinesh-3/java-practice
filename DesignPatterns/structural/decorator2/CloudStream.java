package DesignPatterns.structural.decorator2;

public class CloudStream implements Stream {
  public void write(String data) {
    System.out.println("Storing " + data);
  }
}
