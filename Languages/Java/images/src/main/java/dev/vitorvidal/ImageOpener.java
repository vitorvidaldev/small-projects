package dev.vitorvidal;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class ImageOpener {
    public static Mat openImage(String path) {
        try {
            Mat src = Imgcodecs.imread(path, Imgcodecs.IMREAD_COLOR);

            if (src.empty()) {
                System.out.println("Error opening the image in path " + path);
                System.exit(-1);
            }

            return src;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
