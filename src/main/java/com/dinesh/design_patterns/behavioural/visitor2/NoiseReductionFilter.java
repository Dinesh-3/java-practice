package com.dinesh.design_patterns.behavioural.visitor2;

public class NoiseReductionFilter implements AudioFilter {
    @Override
    public void apply(FormatSegment formatSegment) {
        System.out.println("Noise reduction on format segment");
    }

    @Override
    public void apply(FactSegment factSegment) {
        System.out.println("Noise reduction on fact segment");
    }
}
