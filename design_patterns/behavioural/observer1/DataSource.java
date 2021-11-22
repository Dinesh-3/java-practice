package design_patterns.behavioural.observer1;

public class DataSource extends Subject {
  private int value;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
    notifyObservers();
  }
}
