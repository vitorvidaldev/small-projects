
public class TestInterrupts {

    public static void main(String[] args) throws InterruptedException {
        int sum = 1 + 1;
        if (sum == 2) {
            throw new InterruptedException();
        }
    }
}