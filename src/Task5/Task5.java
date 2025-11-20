package Task5;

public class Task5 {

    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(() -> {
            try {
                System.out.println("Дочерний спит");
                Thread.sleep(10000);
                System.out.println("Дочерний проснулся (прервался)");
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
                Thread.currentThread().interrupt();
            }
        });

        myThread.start();

        Thread.sleep(1000);

        System.out.println("Прерываем из мэйн потока");
        myThread.interrupt();
    }
}
