package design_patterns.structural.proxy2;

public class Product {
  private int id;
  private String name;

  public Product(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
