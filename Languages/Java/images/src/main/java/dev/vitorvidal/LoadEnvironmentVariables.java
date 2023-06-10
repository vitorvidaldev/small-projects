package dev.vitorvidal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoadEnvironmentVariables {
    private static String variables;
    private static final String imagePath = "images.file_path";

    private static void initVariables() {
        if (variables == null) {
            File envFile = new File("./src/main/resources/environment.properties");
            parseFileContent(envFile);
        }
    }

    private static void parseFileContent(File envFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(envFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                variables += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getImagePath() {
        initVariables();

        String[] lines = variables.split("\n");
        for (String line : lines) {
            if (line.contains(imagePath)) {
                String[] split = line.split("=");
                return split[1];
            }
        }
        throw new RuntimeException("Image path not found");
    }
}
