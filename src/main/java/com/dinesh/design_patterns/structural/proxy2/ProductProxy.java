package com.dinesh.design_patterns.structural.proxy2;

public class ProductProxy extends Product {
  private DbContext context;

  public ProductProxy(int id, DbContext context) {
    super(id);
    this.context = context;
  }

  @Override
  public void setName(String name) {
    super.setName(name);

    context.markAsChanged(this);
  }
}
