package dev.vitorvidal;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Window {
    public void showImage(BufferedImage image) {
        JLabel label = new JLabel(new ImageIcon(image));
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(label);
        f.pack();
        f.setLocation(200, 200);
        f.setVisible(true);
    }
}
