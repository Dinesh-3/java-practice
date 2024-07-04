package com.dinesh.design_patterns.behavioural.mediator1;

public class Button extends UIControl {
  private boolean isEnabled;

  public boolean isEnabled() {
    return isEnabled;
  }

  public void setEnabled(boolean enabled) {
    isEnabled = enabled;
    notifyEventHandlers();
  }
}
