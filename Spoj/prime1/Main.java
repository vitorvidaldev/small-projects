import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nCases = in.nextInt();

        while (nCases != 0) {
            int m, n, flag;
            m = in.nextInt();
            n = in.nextInt();

            if (m == 0) {
                m += 2;
            }

            if (m == 1) {
                m++;
            }

            if (m == 2) {
                System.out.println(m);
                m++;
            }

            if (m % 2 == 0) {
                m++;
            }

            for (int i = m; i <= n; i += 2) {
                flag = 1;

                for (int j = 2; j * j <= i; j++) {
                    if (i % j == 0) {
                        flag = 0;
                        break;
                    }
                }

                if (flag == 1) {
                    System.out.println(i);
                }
            }

            nCases--;
        }
        in.close();
    }
}