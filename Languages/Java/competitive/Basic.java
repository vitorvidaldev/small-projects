import java.util.Scanner;

public class Basic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int r1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int r2 = scanner.nextInt();

            double distFromCenters = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            int distBetweenRadii = Math.abs(r1 - r2);

            if ((distFromCenters == 0 && distBetweenRadii == 0) || distFromCenters == r1 + r2
                    || distFromCenters == distBetweenRadii) {
                System.out.println("E");
            } else if (distFromCenters > r1 + r2 || distFromCenters < distBetweenRadii) {
                System.out.println("I");
            } else if (distFromCenters < r1 + r2 && distFromCenters > distBetweenRadii) {
                System.out.println("O");
            }
        }
        scanner.close();
    }
}