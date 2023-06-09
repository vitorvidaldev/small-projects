package dev.vitorvidal;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;

public class Main {
    public static void main(String[] args) {
        OpenCVUtils.initializeOpenCV();

        Mat image = ImageOpener.openImage("./src/main/resources/images/beau.png");
        String windowName = "Sobel Demo - Simple Edge Detector";
        Mat grayscaleImage = new Mat();
        Mat xGray = new Mat();
        Mat yGray = new Mat();
        Mat xGrayAbs = new Mat();
        Mat yGrayAbs = new Mat();
        Mat gradient = new Mat();
        int scale = 2;
        int delta = 0;
        int depth = CvType.CV_16S;

        // Remove noise by blurring with a Gaussian filter (kernel size = 3)
        Imgproc.GaussianBlur(image, image, new Size(3, 3), 0, 0, Core.BORDER_DEFAULT);

        // Convert the image to grayscale
        Imgproc.cvtColor(image, grayscaleImage, Imgproc.COLOR_RGB2GRAY);

        Imgproc.Sobel(grayscaleImage, xGray, depth, 1, 0, 3, scale, delta, Core.BORDER_DEFAULT);
        Imgproc.Sobel(grayscaleImage, yGray, depth, 0, 1, 3, scale, delta, Core.BORDER_DEFAULT);

        Core.convertScaleAbs(xGray, xGrayAbs);
        Core.convertScaleAbs(yGray, yGrayAbs);

        Core.addWeighted(xGrayAbs, 0.5, yGrayAbs, 0.5, 0, gradient);

        HighGui.imshow(windowName, gradient);
        HighGui.waitKey(0);
    }
}