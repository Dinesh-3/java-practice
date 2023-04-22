package design_patterns.behavioural.strategy2;

public class Demo {
    public static void show() {
        var client = new ChatClient(new DES());
        client.send("Hello World");
    }
}
