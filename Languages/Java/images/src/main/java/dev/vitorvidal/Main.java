package dev.vitorvidal;

import nu.pattern.OpenCV;
import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;

public class Main {
    public static void main(String[] args) {
        OpenCV.loadShared();

        Mat image = ImageOpener.openImage("./src/main/resources/images/beau.png");
        Mat kernel = new Mat();
        Mat dst = new Mat();

        Point anchor = new Point(-1, -1);
        double delta = 0.0;
        Integer depth = -1;
        int kernelSize;

        int ind = 0;
        while (true) {
            kernelSize = 3 + 2 * (ind % 5);
            Mat ones = Mat.ones(kernelSize, kernelSize, CvType.CV_32F);
            Core.multiply(ones, new Scalar(1 / (double) (kernelSize * kernelSize)), kernel);

            Imgproc.filter2D(image, dst, depth, kernel, anchor, delta, Core.BORDER_DEFAULT);
            HighGui.imshow("window", dst);
            int c = HighGui.waitKey(500);

            if (c == 27) {
                break;
            }
            ind++;
        }
        System.exit(0);
    }
}