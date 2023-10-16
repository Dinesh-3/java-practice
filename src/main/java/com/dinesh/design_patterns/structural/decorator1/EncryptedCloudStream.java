package design_patterns.structural.decorator1;

import java.beans.Encoder;
import java.util.Base64;

public class EncryptedCloudStream implements Stream {
  private Stream stream;

  public EncryptedCloudStream(Stream stream) {
    this.stream = stream;
  }

  @Override
  public void write(String data) {
    var encrypted = encrypt(data);
    stream.write(encrypted);
  }

  private String encrypt(String data) {
    System.out.println("Encrypting... " + data);
    byte[] encoded = Base64.getEncoder().encode(data.getBytes());
    return new String(encoded);
  }
}
