package Task7;

class MyThread implements Runnable {
    private final boolean useYield;
    private static final int ITERATIONS = 2000000;

    MyThread(boolean useYield) {
        this.useYield = useYield;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        long start = System.currentTimeMillis();

        for (int i = 0; i < ITERATIONS; i++) {
            if (useYield && i % 100 == 0) {
                Thread.yield();
            }
        }

        long time = System.currentTimeMillis() - start;
        System.out.printf("%s закончил за %d мс%n", name, time);
    }
}
