package design_patterns.behavioural.strategy1;

public class ImageStorage {
  public void store(String fileName, Compressor compressor, Filter filter) {
    compressor.compress(fileName);
    filter.apply(fileName);
  }
}
