package com.dinesh.design_patterns.behavioural.mediator1;

public class ListBox extends UIControl {
  private String selection;

  public String getSelection() {
    return selection;
  }

  public void setSelection(String selection) {
    this.selection = selection;
    notifyEventHandlers();
  }
}
