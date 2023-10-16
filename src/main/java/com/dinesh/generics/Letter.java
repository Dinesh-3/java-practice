package generics;

import java.util.Objects;

public final class Letter {
    private final String sender;
    private final String receiver;

    Letter(String sender, String receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public String sender() {
        return sender;
    }

    public String receiver() {
        return receiver;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Letter) obj;
        return Objects.equals(this.sender, that.sender) &&
                Objects.equals(this.receiver, that.receiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender, receiver);
    }

    @Override
    public String toString() {
        return "Letter[" +
                "sender=" + sender + ", " +
                "receiver=" + receiver + ']';
    }

    public String getSender() {
        return sender;
    }

}
