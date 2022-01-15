import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nCases = in.nextInt();

        while (nCases > 0) {
            int number = in.nextInt();
            BigInteger factorial = BigInteger.ONE;
            for (int i = 2; i <= number; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            System.out.println(factorial);
            nCases--;
        }

        in.close();
    }
}