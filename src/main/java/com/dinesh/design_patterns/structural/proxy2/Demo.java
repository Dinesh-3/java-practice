package com.dinesh.design_patterns.structural.proxy2;

public class Demo {
  public static void show() {
    var dbContext = new DbContext();
    var product = dbContext.getProduct(1);
    product.setName("Updated Name");
    dbContext.saveChanges();

    product.setName("Another name");
    dbContext.saveChanges();

  }
}
