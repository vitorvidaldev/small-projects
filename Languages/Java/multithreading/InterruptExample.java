
public class InterruptExample extends Thread {

    public static Boolean restoreTheState() {
        InterruptExample thread1 = new InterruptExample();
        thread1.start();
        thread1.interrupt();
        return thread1.isInterrupted();
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        if (InterruptExample.restoreTheState()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}