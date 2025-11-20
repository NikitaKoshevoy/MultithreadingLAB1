package Task6;

public class Task6 {
    public static void main(String[] args) {

        WalkThread walkRunnable= new WalkThread();
        Thread walkMinPriority = new Thread(walkRunnable);
        TalkThread talkRunnable = new TalkThread();
        Thread talkMax = new Thread(talkRunnable);

        walkMinPriority.setPriority(Thread.MIN_PRIORITY);
        talkMax.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Запускаем потоки");
        walkMinPriority.start();
        talkMax.start();
    }
}
