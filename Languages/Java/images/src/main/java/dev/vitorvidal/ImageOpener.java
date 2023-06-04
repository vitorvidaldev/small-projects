package dev.vitorvidal;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageOpener {
    public static BufferedImage openImage(String path) throws IOException {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
