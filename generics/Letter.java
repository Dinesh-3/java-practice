package generics;

public record Letter(String sender, String receiver) {

    public String getSender() {
        return sender;
    }

}
