package design_patterns.behavioural.chainOfResponsibilityPractise;

public class Compressor implements Handler{
    private Handler handler;

    public Compressor() {
    }

    public Compressor(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void handle() {
        System.out.println("Compressing...");
        doHandle();
    }

    @Override
    public void doHandle() {
        if(handler == null) return;
        handler.handle();
    }
}
