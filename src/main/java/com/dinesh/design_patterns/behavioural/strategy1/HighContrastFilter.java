package design_patterns.behavioural.strategy1;

public class HighContrastFilter implements Filter{
    @Override
    public void apply(String fileName) {
        System.out.println("Applying High Contrast filter...");
    }
}
