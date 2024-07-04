package com.dinesh.design_patterns.behavioural.chainOfResponsibility3;

public class CORPractise {
    public static void main(String[] args) {

        Logger logger = new Logger();
        Compressor compressor = new Compressor(logger);
        Encryptor encryptor = new Encryptor(compressor);
        encryptor.handle();
    }
}
