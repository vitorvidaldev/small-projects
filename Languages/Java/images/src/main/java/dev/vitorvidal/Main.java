package dev.vitorvidal;

import dev.vitorvidal.handler.EnvironmentVariablesHandler;
import dev.vitorvidal.handler.FileHandler;

import static dev.vitorvidal.utils.Constants.*;

import java.awt.*;
import java.io.File;

import javax.swing.*;

import dev.vitorvidal.label.VideoLabel;

public class Main {
    public static void main(String[] args) {
        File[] videoFiles = FileHandler.getVideoFiles(EnvironmentVariablesHandler.getVideoPath());

        VideoLabel videoLabel = new VideoLabel(videoFiles);

        // Configure the JFrame
        JFrame frame = new JFrame(VIDEO_WINDOW_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // Add the VideoLabel to the JFrame with the CENTER constraint
        frame.add(videoLabel, BorderLayout.CENTER);

        // Set the JFrame's size and visibility
        frame.pack();
        frame.setVisible(true);
    }
}