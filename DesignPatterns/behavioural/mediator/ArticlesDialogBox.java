package DesignPatterns.behavioural.mediator;

public class ArticlesDialogBox {
  private final ListBox articlesListBox = new ListBox();
  private final TextBox titleTextBox = new TextBox();
  private final Button saveButton = new Button();

  public ArticlesDialogBox() {
    articlesListBox.addEventHandler(this::articleSelected);
    titleTextBox.addEventHandler(this::titleChanged);
  }

  public void simulateUserInteraction() {
    articlesListBox.setSelection("Article 1");
    titleTextBox.setContent("");
    titleTextBox.setContent("Article 2");
    System.out.println("TextBox: " + titleTextBox.getContent());
    System.out.println("Button: " + saveButton.isEnabled());
  }

  private void titleChanged() {
    var content = titleTextBox.getContent();
    var isEmpty = (content == null || content.isEmpty());
    saveButton.setEnabled(!isEmpty);
  }

  private void articleSelected() {
    titleTextBox.setContent(articlesListBox.getSelection());
    saveButton.setEnabled(true);
  }
}
