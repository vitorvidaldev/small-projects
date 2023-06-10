package dev.vitorvidal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static dev.vitorvidal.Constants.*;

public class LoadEnvironmentVariables {
    private static String variables;

    private static void initVariables() {
        if (variables == null) {
            File envFile = new File(ENV_FILE_PATH);
            parseFileContent(envFile);
        }
    }

    private static void parseFileContent(File file) {
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            variables =  String.join("\n", lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getImagePath() {
        initVariables();

        String[] lines = variables.split("\n");
        for (String line : lines) {
            if (line.contains(IMAGE_PATH_VARIABLE)) {
                String[] split = line.split("=");
                return split[1];
            }
        }
        throw new RuntimeException("Image path not found");
    }
}
