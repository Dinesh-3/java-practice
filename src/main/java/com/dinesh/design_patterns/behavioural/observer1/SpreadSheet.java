package com.dinesh.design_patterns.behavioural.observer1;

public class SpreadSheet implements Observer {
  private DataSource dataSource;

  public SpreadSheet(DataSource dataSource) {
    this.dataSource = dataSource;
    dataSource.addObserver(this);
  }

  @Override
  public void update() {
    System.out.println("SpreadSheet got notified: " + dataSource.getValue());
  }
}
