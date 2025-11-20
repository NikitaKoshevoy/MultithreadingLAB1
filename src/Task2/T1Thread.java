package Task2;

public class T1Thread extends Thread{
    @Override
    public void run() {
        System.out.println("Переопределенный метод run T1");
        super.run();
    }

    public T1Thread(Runnable task) {
        super(task);
    }
}
