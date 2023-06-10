package dev.vitorvidal.label;

import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class VideoLabel extends JLabel {
    private ArrayList<ImageIcon> frames;
    private int currentFrameIndex;
    private Timer timer;

    public VideoLabel(File[] files) {
        // Load the frames of the video into an ArrayList of ImageIcons
        frames = new ArrayList<>();
        for (File file : files) {
            try {
                ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
                frames.add(imageIcon);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Create a Timer to switch the frames every 33 milliseconds (30 frames per second)
        timer = new Timer(33, e -> {
            // Check if the current frame index is equal to the last frame index
            if (currentFrameIndex == frames.size() - 1) {
                // Get a random video from the ArrayList
                Random random = new Random();
                currentFrameIndex = random.nextInt(frames.size());
            } else {
                // Increment the current frame index
                currentFrameIndex++;
            }

            // Repaint the JLabel with the current frame
            repaint();
        });
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the current frame onto the JLabel
        ImageIcon currentFrame = frames.get(currentFrameIndex);
        currentFrame.paintIcon(this, g, 0, 0);
    }
}