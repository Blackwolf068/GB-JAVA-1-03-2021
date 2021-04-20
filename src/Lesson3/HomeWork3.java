package Lesson3;

public class HomeWork3 {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] initialArray(int len, int initialValue) {
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    public static boolean checkBallance(int[] arr) {
        int leftSum, rightSum;
        for (int i = 1; i < arr.length; i++) {
            leftSum = 0;
            rightSum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j < i) {
                    leftSum += arr[j];
                } else {
                    rightSum += arr[j];
                }
            }
            if (leftSum == rightSum) {
                return true;
            }
        }
        return false;
    }

    public static int[] shiftArray(int[] arr, int n) {
        int a;
        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                a = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = a;
            }
        } else {
            for (int i = 0; i < Math.abs(n); i++) {
                a = arr[0];
                for (int j = 1; j < arr.length; j++) {
                    arr[j - 1] = arr[j];
                }
                arr[arr.length - 1] = a;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        // задание 1
        int[] arr1 = {0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0};
        printArray(arr1);
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 0) {
                arr1[i] = 1;
            } else {
                arr1[i] = 0;
            }
        }
        printArray(arr1);

        // задание 2
        int arr2[] = new int[100];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1;
        }
        printArray(arr2);

        // задание 3
        int arr3[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray(arr3);
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        printArray(arr3);

        // задание 4
        int arr4[][] = new int[6][6];
        for (int i = 0; i < arr4.length; i++) {
            arr4[i][i] = 1;
            arr4[i][arr4.length - i - 1] = 1;
        }
        for (int i = 0; i < arr4.length; i++) {
            printArray(arr4[i]);
        }

        // задание 5
        int arr5[] = initialArray(7,11);
        printArray(arr5);

        // задание 6
        int arr6[] = new int[10];
        for (int i = 0; i < arr6.length; i++) {
            arr6[i] = (int) (Math.random() * 10);
        }
        printArray(arr6);
        int min = arr6[0];
        int max = arr6[0];
        for (int i = 1; i < arr6.length; i++) {
            if (arr6[i] < min) {
                min = arr6[i];
            }
            if (arr6[i] > max) {
                max = arr6[i];
            }
        }
        System.out.printf("MIN = %d, MAX = %d\n", min, max);

        // задание 7
        System.out.println(checkBallance(arr6));

        // задание 8
        printArray(shiftArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, -2));
    }
}
