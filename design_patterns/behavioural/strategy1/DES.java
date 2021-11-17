package design_patterns.behavioural.strategy1;

public class DES implements EncryptionAlgorithm {
    @Override
    public String encrypt(String text) {
        System.out.println("Encrypting message using DES");
        return "encryptedText";
    }
}
