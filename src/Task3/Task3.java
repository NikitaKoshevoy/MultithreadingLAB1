package Task3;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Task3 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите N (кол-во строк): ");
        int n = scan.nextInt();

        Thread Child = new Thread(() -> {
            for (int i=1; i<=n; i++){
                System.out.println("от дочернего потока строка №"+i);
            }
        });

        Child.start();
        try{
            Child.join();
        } catch(InterruptedException e){
            System.out.println("Exception");
        };

        for (int i=1; i<=n; i++){
            System.out.println("от родительского потока строка №"+i);
        }

    }
}
