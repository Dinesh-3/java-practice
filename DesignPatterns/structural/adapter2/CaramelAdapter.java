package DesignPatterns.structural.adapter2;


import DesignPatterns.structural.adapter2.avaFilters.Caramel;

public class CaramelAdapter extends Caramel implements Filter {
  @Override
  public void apply(Image image) {
    init();
    render(image);
  }
}
