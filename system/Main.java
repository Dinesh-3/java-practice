package system;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class Main {
    public static void main(String[] args) {
        // Copy To Clipboard
        String myString = "This text will be copied into clipboard";
        java.awt.datatransfer.StringSelection stringSelection = new java.awt.datatransfer.StringSelection(myString);
        java.awt.datatransfer.Clipboard clipboard = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
