package dev.vitorvidal;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageOpener.openImage("./src/main/resources/images/beau.png");

        Window window = new Window();
        window.showImage(image);

        image = ImageOpener.openImage("./src/main/resources/images/nein.jpg");
        window.showImage(image);

        // Close buffers
        image.flush();
    }
}