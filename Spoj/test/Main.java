import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean hasMeaning = false;
        while (in.hasNextInt()) {
            int input = in.nextInt();
            if (input == 42) {
                hasMeaning = true;
            }

            if (!hasMeaning) {
                System.out.println(input);
            }
        }
        in.close();
    }
}