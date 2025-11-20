package Task7;

public class Task7 {

        public static void main(String[] args) {
            Thread withoutYield = new Thread(new MyThread(false), "Без-yield");
            Thread withYield    = new Thread(new MyThread(true),  "С-yield");

            System.out.println("Запускаем два потока с одинаковым приоритетом (5)");
            withoutYield.start();
            withYield.start();
        }
    }


