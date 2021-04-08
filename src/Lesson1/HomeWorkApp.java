package Lesson1;

public class HomeWorkApp {

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 3;
        int b = -5;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 1000;
        if (value <= 0) {
            System.out.println("Красный");
        }
        else {
            if (value <= 100) {
                System.out.println("Жёлтый");
            }
            else {
                System.out.println("Зелёный");
            }
        }
    }
    public static void compareNumbers() {
        int a = 12;
        int b = 12;
        if (a >= b) {
            System.out.println("a >= b");
        }
        else {
            System.out.println("a < b");
        }
    }

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }
}
