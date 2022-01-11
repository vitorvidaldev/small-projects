import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nTestCases = in.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            long nCandies = in.nextInt();

            if (nCandies <= 2) {
                System.out.println(0);
            } else {
                long upperHalf = (int) Math.ceil((nCandies + 1) / 2.0);
                System.out.println(nCandies - upperHalf);
            }
        }
    }
}