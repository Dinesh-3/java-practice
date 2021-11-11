package DesignPatterns.behavioural.chainOfResponsibilityPractise;

public class Logger implements Handler{
    private Handler handler;

    public Logger() {
    }

    public Logger(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void handle() {
        System.out.println("Logging");
        doHandle();
    }

    @Override
    public void doHandle() {
        if(handler == null) return;
        handler.handle();
    }
}
