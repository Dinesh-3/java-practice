package design_patterns.behavioural.command;


import design_patterns.behavioural.command.editor.Command;

public class BlackAndWhiteCommand implements Command {
  @Override
  public void execute() {
    System.out.println("Black and white");
  }
}
