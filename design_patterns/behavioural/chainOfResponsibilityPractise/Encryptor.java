package design_patterns.behavioural.chainOfResponsibilityPractise;

public class Encryptor implements Handler{
    private Handler handler;

    public Encryptor() {
    }

    public Encryptor(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void handle() {
        System.out.println("Encrypting...");
        doHandle();
    }

    @Override
    public void doHandle() {
        handler.handle();
    }
}
