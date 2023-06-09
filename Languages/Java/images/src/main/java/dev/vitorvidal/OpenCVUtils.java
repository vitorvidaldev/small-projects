package dev.vitorvidal;

import nu.pattern.OpenCV;

public class OpenCVUtils {
    public static void initializeOpenCV() {
        OpenCV.loadShared(); // It requires java 12 or bellow.
    }
}
