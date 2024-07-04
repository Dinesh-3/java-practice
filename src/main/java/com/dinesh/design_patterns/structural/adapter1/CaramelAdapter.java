package com.dinesh.design_patterns.structural.adapter1;

import com.dinesh.design_patterns.structural.adapter1.avaFilters.Caramel;

public class CaramelAdapter extends Caramel implements Filter {
  @Override
  public void apply(Image image) {
    init();
    render(image);
  }
}
