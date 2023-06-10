package dev.vitorvidal.handler;

import java.io.File;

public class FileHandler {
    public static File[] getImageFiles(String path) {
        File folder = new File(path);
        return folder
                .listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".png"));
    }

    public static File[] getVideoFiles(String path) {
        File folder = new File(path);
        return folder
                .listFiles((dir, name) -> name.toLowerCase().endsWith(".mp4") ||
                        name.toLowerCase().endsWith(".mov") ||
                        name.toLowerCase().endsWith(".mkv"));
    }
}
