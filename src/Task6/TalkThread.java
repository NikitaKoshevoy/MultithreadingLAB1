package Task6;

class TalkThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println("TALK " + i);
        }
    }
}