import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.NA;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nTestCases = in.nextInt();

        in.nextLine();

        int best = 0, worst = 0;
        int nAmazing = 0;

        for (int i = 0; i < nTestCases; i++) {
            int score = in.nextInt();

            if (i == 0) {
                best = score;
                worst = score;
            } else {
                if (score > best) {
                    best = score;
                    nAmazing++;
                } else if (score < worst) {
                    worst = score;
                    nAmazing++;
                }
            }
        }

        System.out.println(nAmazing);
    }
}