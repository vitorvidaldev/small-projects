import java.io.PrintWriter;
import java.util.Scanner;

public class FastOutputExample {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        in.close();

        PrintWriter writer = new PrintWriter(System.out);
        writer.write(String.valueOf(input) + '\n');
        writer.flush();
        writer.close();
    }
}