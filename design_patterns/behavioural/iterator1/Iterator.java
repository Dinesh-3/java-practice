package design_patterns.behavioural.iterator1;

public interface Iterator {
  boolean hasNext();
  Product current();
  void next();
}
