package Lesson2;

import com.sun.org.apache.xpath.internal.objects.XString;

public class HomeWork2 {

    static boolean checkSum(int a, int b) {
        boolean SumCheck;
        if (a + b >= 10 && a + b <=20) {
            SumCheck = true;
        } else {
            SumCheck = false;
        }
        return SumCheck;
    }

    static void checkPositive(int a) {
        if (a >= 0) {
            System.out.println(a + " - положительное");
        } else {
            System.out.println(a + " - отрицательное");
        }
    }

    static boolean checkNegative(int a) {
        boolean check;
        if (a < 0) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    static void printString(String str, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(str);
        }
    }

    static boolean leapYear(int a) {
        int b;
        boolean leap = false;
        b = a / 100;
        if (a % 100 != 0) {
            if (a % 4 == 0) {
                leap = true;
            }
        } else {
            if (b > 0 && b % 4 == 0) {
                leap = true;
            }
        }
        return leap;
    }

    public static void main(String[] args) {
        System.out.println(checkSum(10, 5));
        checkPositive(-580);
        System.out.println(checkNegative(27));
        printString("Hello, World!!!", 4);
        System.out.println(leapYear(2021));
    }
}
