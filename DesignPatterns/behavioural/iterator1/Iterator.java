package DesignPatterns.behavioural.iterator1;

public interface Iterator {
  boolean hasNext();
  Product current();
  void next();
}
