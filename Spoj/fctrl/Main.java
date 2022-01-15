import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nCases = in.nextInt();

        while (nCases != 0) {
            int number = in.nextInt();
            int mult2 = countOcurrences(number, 2);
            int mult5 = countOcurrences(number, 5);

            System.out.println(Math.min(mult2, mult5));
            nCases--;
        }
        in.close();
    }

    public static int countOcurrences(int a, int b) {
        int result = 0;
        int originalValue = b;

        while (a / b > 0) {
            result += a / b;
            b *= originalValue;
        }

        return result;
    }
}