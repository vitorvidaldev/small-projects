package dev.vitorvidal.label;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

import static dev.vitorvidal.utils.Constants.*;

import java.awt.*;

public class ImageLabel extends JLabel {
    private JLabel imageLabel;

    public ImageLabel(File[] files) {
        // Configure the JLabel to hold the images
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);

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

        // Create a Timer to switch the images every 4 seconds
        Timer timer = new Timer(4000, e -> {
            // Check if the ArrayList is not empty
            if (!images.isEmpty()) {
                // Get a random image from the ArrayList
                Random random = new Random();
                Image image = images.get(random.nextInt(images.size()));

                // Set the JLabel's icon to the loaded image
                imageLabel.setIcon(new ImageIcon(image));
            }
        });
        timer.start();
    }
}
