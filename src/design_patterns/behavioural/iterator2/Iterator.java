package design_patterns.behavioural.iterator2;

public interface Iterator {
  boolean hasNext();
  Product current();
  void next();
}
