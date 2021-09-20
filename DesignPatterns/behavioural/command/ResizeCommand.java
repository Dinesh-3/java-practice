package DesignPatterns.behavioural.command;


import DesignPatterns.behavioural.command.editor.Command;

public class ResizeCommand implements Command {
  @Override
  public void execute() {
    System.out.println("Resize");
  }
}
