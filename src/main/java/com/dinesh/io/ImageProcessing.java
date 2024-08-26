package com.dinesh.io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Paths;

public class ImageProcessing extends Main{
    public static void main(String[] args) {
        String imagePath = "/home/dinesh/Pictures/Others/autoinn_dashboard.png";
//
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(imagePath));
//            System.out.println("bufferedReader = " + bufferedReader);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        // width of the image
        int width = 50;

        // height of the image
        int height = 50;

        // For storing image in RAM
        BufferedImage image = null;

        // READ IMAGE
        try {
            File input_file = new File(imagePath);

            // image file path create an object of
            // BufferedImage type and pass as parameter the
            // width,  height and image int
            // type. TYPE_INT_ARGB means that we are
            // representing the Alpha , Red, Green and Blue
            // component of the image pixel using 8 bit
            // integer value.

            image = new BufferedImage(
                    width, height, BufferedImage.TYPE_INT_ARGB);

            // Reading input file
            image = ImageIO.read(input_file);

            System.out.println("Reading complete.");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        System.out.println("image = " + image);
        // WRITE IMAGE
        try {
            // Output file path
            var output_file = new File(Paths.get("").toAbsolutePath() + "/src/main/java/com/dinesh/io/converted.png");

            // Writing to file taking type and path as
            ImageIO.write(image, "png", output_file);

            System.out.println("Writing complete.");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
