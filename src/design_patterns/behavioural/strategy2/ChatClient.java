package design_patterns.behavioural.strategy2;

public class ChatClient {
    private EncryptionAlgorithm encryptionAlgorithm;

    public ChatClient(EncryptionAlgorithm encryptor) {
        this.encryptionAlgorithm = encryptor;
    }

    public void send(String message) {
        var encryptedMessage = encryptionAlgorithm.encrypt(message);

        System.out.println("Sending the encrypted message...");
    }
}
