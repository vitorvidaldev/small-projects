package dev.vitorvidal;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static dev.vitorvidal.Constants.*;

public class Main {
    public static void main(String[] args) {
        File[] files = getImageFiles(LoadEnvironmentVariables.getImagePath());

        // Configure the JFrame
        JFrame frame = new JFrame(IMAGE_WINDOW_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Configure the JLabel to hold the images
        JLabel imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(IMAGE_WINDOW_WIDTH, IMAGE_WINDOW_HEIGHT));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        frame.add(imageLabel, BorderLayout.CENTER);

        frame.setSize(IMAGE_WINDOW_WIDTH, IMAGE_WINDOW_HEIGHT);

        // Load the images into an ArrayList
        ArrayList<Image> images = new ArrayList<>();
        for (File file : files) {
            try {
                Image image = ImageIO.read(file);
                images.add(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Display the images in the JLabel
        for (Image image : images) {
            // Set the JLabel's icon to the scaled image
            imageLabel.setIcon(new ImageIcon(image));
        }

        // Create a Timer to switch the images every 4 seconds
        Timer timer = new Timer(4000, e -> {
            // Check if the ArrayList is not empty
            if (!images.isEmpty()) {
                // Get a random image from the ArrayList
                Random random = new Random();
                Image image = images.get(random.nextInt(images.size()));

                // Resize the image to fit the JLabel's size
                Image resizedImage = image.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(),
                        Image.SCALE_SMOOTH);

                // Set the JLabel's icon to the loaded image
                imageLabel.setIcon(new ImageIcon(resizedImage));
            }
        });
        timer.start();

        // Set the preferred size of the imageLabel after adding it to the frame
        imageLabel.setPreferredSize(new Dimension(IMAGE_WINDOW_WIDTH, IMAGE_WINDOW_HEIGHT));

        // Set the JFrame's size and visibility
        frame.pack();
        frame.setVisible(true);

        // Set the JFrame's default close operation to exit the program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static File[] getImageFiles(String path) {
        // Get a list of all the image files in the specified folder
        File folder = new File(path);
        return folder
                .listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".png"));
    }
}