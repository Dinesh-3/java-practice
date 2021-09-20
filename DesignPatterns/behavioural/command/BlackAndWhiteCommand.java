package DesignPatterns.behavioural.command;


import DesignPatterns.behavioural.command.editor.Command;

public class BlackAndWhiteCommand implements Command {
  @Override
  public void execute() {
    System.out.println("Black and white");
  }
}
