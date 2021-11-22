package design_patterns.behavioural.visitor1;

public class AnchorNode implements HtmlNode {
  @Override
  public void execute(Operation operation) {
    operation.apply(this);
  }
}
