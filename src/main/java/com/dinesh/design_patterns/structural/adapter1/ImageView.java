package design_patterns.structural.adapter1;

public class ImageView {
  private Image image;

  public ImageView(Image image) {
    this.image = image;
  }

  public void apply(Filter filter) {
    filter.apply(image);
  }
}
