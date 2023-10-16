package utils;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class UI {

    public static void main(String[] argv) throws Exception {

        JTextField textField = new JTextField();

        textField.addKeyListener(new MKeyListener());

        JFrame jframe = new JFrame();

        jframe.add(textField);

        jframe.setSize(200, 200);

        jframe.setVisible(true);

    }
}

class MKeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent event) {

        char ch = event.getKeyChar();
        System.out.print(event.getKeyChar());

//        if (event.getKeyCode() == KeyEvent.VK_HOME) {
//
//            System.out.println("Key codes: " + event.getKeyCode());
//
//        }
    }
}