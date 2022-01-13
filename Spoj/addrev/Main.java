import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] main) {
        Scanner in = new Scanner(System.in);
        int nCases = in.nextInt();

        while (nCases != 0) {

            int a = in.nextInt();
            int b = in.nextInt();

            String s1 = new StringBuilder(String.valueOf(a)).reverse().toString();
            String s2 = new StringBuilder(String.valueOf(b)).reverse().toString();

            int result = Integer.parseInt(s1) + Integer.parseInt(s2);

            String reverseResult = new StringBuilder(String.valueOf(result)).reverse().toString();

            System.out.println(Integer.parseInt(reverseResult));

            nCases--;
        }
        in.close();
    }
}