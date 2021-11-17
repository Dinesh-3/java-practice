package design_patterns.structural.adapter2;

public class VividFilter implements Filter {
  @Override
  public void apply(Image image) {
    System.out.println("Applying Vivid Filter");
  }
}
