package com.dinesh.design_patterns.behavioural.chainOfResponsibility1;

public class Logger extends Handler {
  public Logger(Handler next) {
    super(next);
  }

  @Override
  public boolean doHandle(HttpRequest request) {
    System.out.println("Log");

    return false;
  }
}
