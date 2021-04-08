package Lesson4;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameXO {

    private static final char DEFAULT = '_';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final int SIZE = 3;

    private static final char[][] MAP = new char[SIZE][SIZE];

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DEFAULT;
            }
        }
    }

    private static boolean fullMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == DEFAULT) return false;
            }
        }
        return true;
    }

    private static void printMap() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + "|");
            }
            System.out.println();
        }
    }

    private static boolean isCellValid(int x, int y) {
        boolean isInMap = x > 0 && x <= SIZE && y > 0 && y <= SIZE;
        return isInMap && MAP[x - 1][y - 1] == DEFAULT;
    }

    private static void makeStep(int x, int y, char value) {
        MAP[x - 1][y - 1] = value;
    }

    private static void moveAI() {
        // TODO: 06.04.2021 логика хода компьютера (интересная)
        // DONE
        int rnd, x, y;
        while (true) {
            rnd = (int) (Math.random() * SIZE * SIZE);
            x = rnd / SIZE + 1;
            y = rnd % SIZE + 1;
            if (isCellValid(x, y)) {
                System.out.printf("Компьютер сделал ход: %d, %d \n", x, y);
                MAP[x - 1][y - 1] = DOT_O;
                return;
            }
        }
    }

    private static void aiAwait() {
        for (int i = 0; i < 10; i++) {
            System.out.print(" * ");
            try {
                TimeUnit.MILLISECONDS.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    private static boolean isWin(char symb) {
        // TODO: 06.04.2021 логика проверки на победу
        // DONE
        boolean flagWin;
        // проверка по строкам
        for (int i = 0; i < SIZE; i++) {
            flagWin = true;
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] != symb) flagWin = false;
            }
            if (flagWin) return true;
        }
        // проверка по столбцам
        for (int i = 0; i < SIZE; i++) {
            flagWin = true;
            for (int j = 0; j < SIZE; j++) {
                if (MAP[j][i] != symb) flagWin = false;
            }
            if (flagWin) return true;
        }
        // проверка по основной диагонали
        flagWin = true;
        for (int i = 0; i < SIZE; i++) {
            if (MAP[i][i] != symb) flagWin = false;
        }
        if (flagWin) return true;
        //поверка по вторичной диагонали
        flagWin = true;
        for (int i = 0; i < SIZE; i++) {
            if (MAP[i][SIZE - i - 1] != symb) flagWin = false;
        }
        if (flagWin) return true;
        return false;
    }

    private static void startGame() {
        initMap();
        System.out.println("Вы в игре крестики и нолики.");
        System.out.println("Для победы необходимо собрать три крестика подряд.");
        System.out.println("Для того, чтобы сделать ход, введите\n2 целых числа от 1 до 3 - номер строки и номер " +
                "столбца...");
        printMap();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Делайте ваш ход:");
            String[] values = in.nextLine().split(" ");
            if (values.length != 2) {
                System.out.println("Вы ввели некорректные данные.\nВведите ровно два числа от 1 до 3!");
                continue;
            }
            try {
                int x = Integer.parseInt(values[0]);
                int y = Integer.parseInt(values[1]);
                if (isCellValid(x, y)) {
                    makeStep(x, y, DOT_X);
                    if (isWin(DOT_X)) {
                        printMap(); // добавил вывод поля перед сообщением о победе
                        System.out.println("Вы победили");
                        showEndGameDialog(in);
                        break;
                    }
                    // TODO: 06.04.2021 обработать случай ничьей
                    // DONE
                    if (fullMap()) {
                        printMap();
                        System.out.println("Увы, ничья");
                        showEndGameDialog(in);
                        break;
                    }
                    printMap();
                    System.out.println("Ход компьютера:");
                    aiAwait();
                    moveAI();
                    if (isWin(DOT_O)) {
                        printMap(); // добавил вывод поля перед сообщением о проигрыше
                        System.out.println("Вы проиграли");
                        showEndGameDialog(in);
                        break;
                    }
                    printMap();
                } else {
                    System.out.println("Невозможно сделать такой ход! Введите другие значения");
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели некорректные данные.\nДанные должны быть числами от 1 до 3");
            }
        }
    }

    private static void showEndGameDialog(Scanner in) {
        System.out.println("Введите 1, чтобы начать новую игру");
        System.out.println("Для выхода введите любую другую клавишу");

        System.out.println("Введите команду...");
        String command = in.next();
        if (command.equals("1")) {
            startGame();
            return;
        }
        System.out.println("Игра завершена!");

    }

    public static void main(String[] args) {
        startGame();
    }


}