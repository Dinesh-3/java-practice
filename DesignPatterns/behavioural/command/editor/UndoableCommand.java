package DesignPatterns.behavioural.command.editor;

public interface UndoableCommand extends Command {
  void unexecute();
}
