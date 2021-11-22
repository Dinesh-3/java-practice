package design_patterns.behavioural.visitor1;

public interface Operation {
  void apply(HeadingNode heading);
  void apply(AnchorNode anchor);
}
