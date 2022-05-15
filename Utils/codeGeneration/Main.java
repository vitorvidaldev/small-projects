import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public final static void main(String[] args) {
        Map<Integer, String> scope = getScopeData();
        for (int i = 0; i < scope.size(); i++) {
            String line = scope.get(i);
            Integer whiteSpaceCount = countWhitespacesBeforeFirstCharacter(line);
            switch (whiteSpaceCount) {
                case 0:
                    if (line.contains("entity")) {
                        continue;
                    }
                    break;
                case 2:
                    String className = line.trim().split(":")[0];
                    className = uppercaseFirstLetter(className);
                    createClassFile(className);
                    break;
                case 4:
                    System.out.println("TODO");
                    break;
                default:
            }
        }
    }

    private static Map<Integer, String> getScopeData() {
        Map<Integer, String> fileData = new TreeMap<>();

        try {
            Integer lineCount = 0;
            File scopeFile = new File("./scope.yaml");
            Scanner reader = new Scanner(scopeFile);

            while (reader.hasNextLine()) {
                fileData.put(lineCount, reader.nextLine());
                lineCount++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Eerror occurred while processing scope file");
            e.printStackTrace();
        }
        return fileData;
    }

    private static String uppercaseFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static void createClassFile(String className) {
        try {
            File file = new File(className + ".java");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static Integer countWhitespacesBeforeFirstCharacter(String line) {
        Integer whitespaceCount = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ')
                whitespaceCount++;
            else
                break;
        }
        return whitespaceCount;
    }
}