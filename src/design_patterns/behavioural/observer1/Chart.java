package design_patterns.behavioural.observer1;

public class Chart implements Observer {
  private DataSource dataSource;

  public Chart(DataSource dataSource) {
    this.dataSource = dataSource;
    dataSource.addObserver(this);
  }

  @Override
  public void update() {
    System.out.println("Chart got updated: " + dataSource.getValue());
  }
}
