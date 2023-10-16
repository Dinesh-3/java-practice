package design_patterns.behavioural.command1.editor;

public interface UndoableCommand extends Command {
  void unexecute();
}
