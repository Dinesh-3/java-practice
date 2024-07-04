package com.dinesh.design_patterns.structural.adapter1;

import com.dinesh.design_patterns.structural.adapter1.avaFilters.Caramel;

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
