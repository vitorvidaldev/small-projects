import java.util.Scanner;

public class ObfuscatedProperty {

    // If the sum of two indices, n and m, is a power of 2, then f(n) and f(m) are coprime.
    // Coprime numbers or relatively prime numbers are those number that have their HCF (Highest Common Factor) as 1. In other words, two numbers are coprime if they have no common factors other than 1.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            String s = scanner.next();
            int length = s.length() / 2;

            for (int j = 0; j < length; j = j + 2) {
                System.out.print(s.charAt(j));
            }
            System.out.println();
        }

        scanner.close();
    }
}