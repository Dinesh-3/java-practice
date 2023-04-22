package design_patterns.behavioural.command1;


import design_patterns.behavioural.command1.editor.Command;

public class BlackAndWhiteCommand implements Command {
  @Override
  public void execute() {
    System.out.println("Black and white");
  }
}
