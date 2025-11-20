package Task1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите N (кол-во строк): ");
        int n = scan.nextInt();

        Thread child = new Thread(() -> {
            for (int i=1; i<=n; i++){
                System.out.println("от дочернего потока строка №"+i);
            }
        });

        child.start();

        for (int i=1; i<=n; i++){
            System.out.println("от родительского потока строка №"+i);
        }

    }
}
