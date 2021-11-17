package design_patterns.behavioural.strategy;

public class ImageStorage {
  public void store(String fileName, Compressor compressor, Filter filter) {
    compressor.compress(fileName);
    filter.apply(fileName);
  }
}
