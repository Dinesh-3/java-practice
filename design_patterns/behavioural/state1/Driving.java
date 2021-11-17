package design_patterns.behavioural.state1;

public class Driving implements TravelMode {
    @Override
    public Object getEta() {
        System.out.println("Calculating ETA (driving)");
        return 1;
    }

    @Override
    public Object getDirection() {
        System.out.println("Calculating Direction (driving)");
        return 1;
    }
}
