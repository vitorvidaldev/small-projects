import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n, m, a;
        n = in.nextDouble();
        m = in.nextDouble();
        a = in.nextDouble();

        in.close();

        double height = Math.ceil(n / a);
        double width = Math.ceil(m / a);
        double nSquares = height * width;

        System.out.println((long) nSquares);
    }
}
