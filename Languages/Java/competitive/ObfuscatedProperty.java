import java.util.Scanner;

public class ObfuscatedProperty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String asterisc = "*";
        String dot = ".";
        String forwardSlash = "/";
        String backSlash = "\\";

        for (int i = 1; i <= n; i++) {
            int l = scanner.nextInt();
            int c = scanner.nextInt();
            int s = scanner.nextInt();

            for (int j = 0; j < (l * (s + 1)) + 1; j++) {
                for (int k = 0; k < (c * (s + 1)) + 1; k++) {
                    int x = j % (s + 1);
                    int y = k % (s + 1);
                    if (x == 0 || y == 0) {
                        System.out.print(asterisc);
                    } else {
                        if (x == y) {
                            if (x % 2 == 0) {
                                System.out.print(backSlash);
                            } else {
                                System.out.print(forwardSlash);
                            }
                        } else {
                            System.out.print(dot);
                        }
                    }
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}