package Task4;

import java.util.List;

public class MyThread extends Thread{

    private final List<String> messages;

    MyThread(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public void run() {
        for (String message : messages) {
            System.out.println(message);
            super.run();
        }
    }
}
