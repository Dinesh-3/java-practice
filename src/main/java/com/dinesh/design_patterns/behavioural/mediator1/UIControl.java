package design_patterns.behavioural.mediator1;

import java.util.ArrayList;
import java.util.List;

public abstract class UIControl {
  private final List<EventHandler> eventHandlers = new ArrayList<>();

  public void addEventHandler(EventHandler observer) {
    eventHandlers.add(observer);
  }

  protected void notifyEventHandlers() {
    for (var observer : eventHandlers)
      observer.handle();
  }
}
