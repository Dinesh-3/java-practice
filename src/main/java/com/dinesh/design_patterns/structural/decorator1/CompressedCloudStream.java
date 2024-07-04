package com.dinesh.design_patterns.structural.decorator1;

public class CompressedCloudStream implements Stream {
  private Stream stream;

  public CompressedCloudStream(Stream stream) {
    this.stream = stream;
  }

  @Override
  public void write(String data) {
    var compressed = compress(data);
    stream.write(compressed);
  }

  private String compress(String data) {
    System.out.println("Compressing.... " + data);
    return data.substring(data.length() / 2);
  }
}
