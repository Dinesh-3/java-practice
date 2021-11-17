package design_patterns.behavioural.command;


import design_patterns.behavioural.command.editor.Command;

public class ResizeCommand implements Command {
  @Override
  public void execute() {
    System.out.println("Resize");
  }
}
