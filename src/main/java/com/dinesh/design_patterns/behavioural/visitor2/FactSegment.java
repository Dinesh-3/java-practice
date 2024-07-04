package com.dinesh.design_patterns.behavioural.visitor2;

public class FactSegment extends Segment {
  @Override
  public void applyFilter(AudioFilter filter) {
    filter.apply(this);
  }
}
