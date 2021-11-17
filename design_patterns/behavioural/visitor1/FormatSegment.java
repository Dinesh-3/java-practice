package design_patterns.behavioural.visitor1;

public class FormatSegment extends Segment {
  @Override
  public void applyFilter(AudioFilter filter) {
    filter.apply(this);
  }
}
