package DesignPatterns.behavioural.strategy1;

public class AES implements EncryptionAlgorithm {
    @Override
    public String encrypt(String text) {
        System.out.println("Encrypting message using AES");
        return "encryptedText";
    }
}
