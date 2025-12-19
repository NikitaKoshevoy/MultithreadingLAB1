package Task8;

public class Task8 {

    private static boolean flag = true;
    private static boolean finished = false;
    private static final Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {
        final int M = 500;
        final int K = 10000;

        Thread producer = new Thread(() -> {
            try {
                while (!finished) {
                    Thread.sleep(M);

                    synchronized (monitor) {
                        flag = !flag;
                        System.out.println("Producer переключил → " + flag);
                        monitor.notify();
                    }
                }
            } catch (InterruptedException ignored) {}
            System.out.println("Producer завершился");
        });

        Thread consumer = new Thread(() -> {
            int remaining = K;
            int step = M / 10;

            try {
                while (remaining > 0 && !finished) {
                    synchronized (monitor) {
                        while (!flag && !finished) {
                            System.out.println("Consumer ждёт (flag = false)");
                            monitor.wait();
                        }

                        if (finished) break;

                        System.out.println("Consumer: осталось " + remaining + " мс");
                        remaining -= step;
                        if (remaining < 0) remaining = 0;
                    }

                    Thread.sleep(step);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            synchronized (monitor) {
                finished = true;
                monitor.notify();
            }
            System.out.println("Consumer дошёл до нуля — завершаем!");
        });

        producer.start();
        consumer.start();

        consumer.join();
        producer.join();

        System.out.println("Программа завершена!");
    }
}
