import javafx.util.Pair;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter the numbers or press ! to stop");
        Memory memory = new Memory();
        FirstThread firstThread = new FirstThread(memory);
        SecondThread secondThread = new SecondThread(memory);
        Thread t1 = new Thread(firstThread);
        t1.start();
        Thread t2 = new Thread(secondThread);
        t2.start();
    }
}

class FirstThread implements Runnable {

    private Memory m;

    FirstThread(Memory m) {
        this.m = m;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (sc.hasNext()) {
                String number = sc.nextLine();
                if (!number.equals("!")) {
                    int value = Parser.parseValue(number);
                    if(value != 0) m.addNumber(number, value);
                    else System.out.println("Enter the correct number!");
                } else break;
            } else break;

        }
        m.removeAll();
    }
}

class SecondThread implements Runnable {

    private Memory m;

    SecondThread(Memory m) {
        this.m = m;
    }

    public void run() {
        while (m.getCount() >= 0) {
            try {
                Thread.sleep(5000);
                Pair<String, Integer> minimum = m.getMinimum();
                if (minimum != null) {
                    m.removeNumber(minimum);
                    System.out.println("Removed: " + minimum.getKey());
                }else
                    System.out.println("Empty collection");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
