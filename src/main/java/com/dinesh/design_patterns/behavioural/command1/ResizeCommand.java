package com.dinesh.design_patterns.behavioural.command1;


import com.dinesh.design_patterns.behavioural.command1.editor.Command;

public class ResizeCommand implements Command {
  @Override
  public void execute() {
    System.out.println("Resize");
  }
}
