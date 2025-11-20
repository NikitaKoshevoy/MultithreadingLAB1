package Task2;

public class Task2 {
    public static void main(String[] args) {
        T2Thread thread2 = new T2Thread();
        T1Thread thread1 = new T1Thread(thread2);

        thread1.start();
    }
}
