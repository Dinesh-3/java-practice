package design_patterns.behavioural.command.editor;

public interface UndoableCommand extends Command {
  void unexecute();
}
