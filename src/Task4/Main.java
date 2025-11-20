package Task4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int threadCount = 4 + random.nextInt(3);

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            int stringCount = 3 + random.nextInt(8);

            List<String> messages = new ArrayList<>();
            for (int j = 0; j < stringCount; j++) {
                messages.add("Thread " + i + " - String " + j);
            }

            MyThread myThread = new MyThread(messages);
            threads.add(myThread);
        }
        for(Thread t:threads){
            t.start();
        }

    }
}