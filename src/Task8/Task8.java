package Task8;

public class Task8 {
    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        final int M = 500;
        final int K = 10000;

        Thread producer = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(M);
                    flag = !flag;
                    System.out.println("Producer переключил флаг" + flag);
                }
            } catch (InterruptedException e) {
                System.out.println("Producer остановлен");
            }
        });

        Thread consumer = new Thread(() -> {
            int remaining = K;
            int step = M / 10;

            while (remaining > 0) {
                if (flag) {
                    System.out.println("Consumer: осталось " + remaining + " мс");
                    remaining -= step;
                    if (remaining < 0) {
                        remaining = 0;
                    }
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            System.out.println("Consumer: дошел до нуля!");
            producer.interrupt();
        });

        producer.start();
        consumer.start();

        consumer.join();
        producer.join();
        System.out.println("Программа завершена!");
    }
}
