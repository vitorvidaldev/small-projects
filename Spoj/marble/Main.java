import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n, k, q;
        n = in.nextInt();
        k = in.nextInt();
        q = in.nextInt();

        Boolean[][] board = new Boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = false;
            }
        }

        while (k != 0) {
            board[in.nextInt() - 1][in.nextInt() - 1] = true;
            k--;
        }

        String c;
        int D, u, v;
        int result;
        while (q != 0) {
            result = 0;

            c = in.next();
            D = in.nextInt();
            u = in.nextInt() - 1;
            v = in.nextInt() - 1;
            in.nextLine();

            while (D != 0) {
                if (board[u][v] == false) {
                    board[u][v] = true;
                    result++;
                } else {
                    Boolean aux = false;
                    while (!aux) {
                        if (c == "R") {
                            v--;
                            if (v < n - 1) {
                                aux = true;
                                continue;
                            }
                        } else if (c == "L") {
                            v++;
                            if (v > n - 1) {
                                aux = true;
                                continue;
                            }
                        } else if (c == "B") {
                            u--;
                            if (u < n - 1) {
                                aux = true;
                                continue;
                            }
                        } else if (c == "T") {
                            u++;
                            if (u > n - 1) {
                                aux = true;
                                continue;
                            }
                        }
                        if (board[u][v] == true) {
                            aux = true;
                            continue;
                        }
                        board[u][v] = true;
                        result++;
                        aux = true;
                    }
                }

                D--;
            }

            System.out.println(result);
            q--;
        }

    }
}