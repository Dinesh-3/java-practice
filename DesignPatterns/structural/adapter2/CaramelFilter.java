package DesignPatterns.structural.adapter2;

import DesignPatterns.structural.adapter2.avaFilters.Caramel;

public class CaramelFilter implements Filter {
  private Caramel caramel;

  public CaramelFilter(Caramel caramel) {
    this.caramel = caramel;
  }

  @Override
  public void apply(Image image) {
    caramel.init();
    caramel.render(image);
  }
}
