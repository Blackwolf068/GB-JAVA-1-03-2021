package Lesson8;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Window extends JFrame {

    private static final ImageIcon ICON_X = new ImageIcon("x.png");
    private static final ImageIcon ICON_O = new ImageIcon("o.png");
    private static final ImageIcon ICON_DEFAULT = new ImageIcon("def.png");

    public Window() throws HeadlessException {
        setSize(300, 390);
        setLocation(300, 300);
        setTitle("Крестики - нолики");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("ИГРА");
        JMenuItem item1 = new JMenuItem("новая");
        JMenuItem item2 = new JMenuItem("выход");
        item2.addActionListener(e -> dispose());
        item1.addActionListener(e -> {
            new Window();
            dispose();
        });

        file.add(item1);
        file.add(item2);

        menuBar.add(file);

        add(menuBar);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("");

        JPanel fp = new JPanel(new GridLayout(3, 3));
        JButton[][] buttons = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setIcon(ICON_DEFAULT);
                buttons[i][j].setDisabledIcon(ICON_DEFAULT);
                final int finalI = i;
                final int finalJ = j;
                buttons[i][j].addActionListener(e -> {
                    System.out.println(finalI + " " + finalJ);
                    buttons[finalI][finalJ].setIcon(ICON_X);
                    buttons[finalI][finalJ].setEnabled(false);
                    buttons[finalI][finalJ].setDisabledIcon(ICON_X);
                    if (isWin(ICON_X, buttons)) {
                        label.setText("Вы победили!");
                        label.setVisible(true);
                        finish(buttons);
                        return;
                    }
                    if (fullMap(buttons)) {
                        label.setText("Ничья!");
                        label.setVisible(true);
                        finish(buttons);
                        return;
                    }
                    moveAI(buttons);
                    if (isWin(ICON_O, buttons)) {
                        label.setText("Вы проиграли!");
                        label.setVisible(true);
                        finish(buttons);
                        return;
                    }
                });
                fp.add(buttons[i][j]);
            }
        }

        panel.add(menuBar, BorderLayout.NORTH);
        panel.add(fp, BorderLayout.CENTER);
        panel.add(label, BorderLayout.SOUTH);
        label.setVisible(false);
        add(panel);
        panel.setVisible(true);
        setResizable(false);
        setVisible(true);
    }

    private static boolean fullMap(JButton [][] buttons) {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                if (buttons[i][j].getIcon() == ICON_DEFAULT) return false;
            }
        }
        return true;
    }

    private static JButton[][] finish (JButton [][] buttons) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
        return buttons;
    }

    public static JButton[][] moveAI (JButton [][] buttons) {
        int cnt;
        for (int i = 0; i < buttons.length; i++) {
            cnt = 0;
            for (int j = 0; j < buttons.length; j++) {
                if (buttons[i][j].getIcon() == ICON_X) cnt ++;
            }
            if (cnt == 2) for (int j = 0; j < buttons.length; j++) {
                if (buttons[i][j].getIcon() == ICON_DEFAULT) {
                    buttons[i][j].setEnabled(false);
                    buttons[i][j].setDisabledIcon(ICON_O);
                    buttons[i][j].setIcon(ICON_O);
                    System.out.printf("Компьютер сделал ход: %d, %d \n", i + 1, j + 1);
                    return buttons;
                }
            }
        }
        for (int i = 0; i < buttons.length; i++) {
            cnt = 0;
            for (int j = 0; j < buttons.length; j++) {
                if (buttons[j][i].getIcon() == ICON_X) cnt ++;
            }
            if (cnt == 2) for (int j = 0; j < buttons.length; j++) {
                if (buttons[j][i].getIcon() == ICON_DEFAULT) {
                    buttons[j][i].setEnabled(false);
                    buttons[j][i].setDisabledIcon(ICON_O);
                    buttons[j][i].setIcon(ICON_O);
                    System.out.printf("Компьютер сделал ход: %d, %d \n", j + 1, i + 1);
                    return buttons;
                }
            }
        }
        cnt = 0;
        for (int i = 0; i < buttons.length; i++) if (buttons[i][i].getIcon() == ICON_X) cnt ++;
        if (cnt == 2) for (int i = 0; i < buttons.length; i++) {
            if (buttons[i][i].getIcon() == ICON_DEFAULT) {
                buttons[i][i].setEnabled(false);
                buttons[i][i].setDisabledIcon(ICON_O);
                buttons[i][i].setIcon(ICON_O);
                System.out.printf("Компьютер сделал ход: %d, %d \n", i + 1, i + 1);
                return buttons;
            }
        }
        cnt = 0;
        for (int i = 0; i < buttons.length; i++) if (buttons[i][buttons.length - i - 1].getIcon() == ICON_X) cnt ++;
        if (cnt == 2) for (int i = 0; i < buttons.length; i++) {
            if (buttons[i][buttons.length - i - 1].getIcon() == ICON_DEFAULT) {
                buttons[i][buttons.length - i - 1].setEnabled(false);
                buttons[i][buttons.length - i - 1].setDisabledIcon(ICON_O);
                buttons[i][buttons.length - i - 1].setIcon(ICON_O);
                System.out.printf("Компьютер сделал ход: %d, %d \n", i + 1, buttons.length - i);
                return buttons;
            }
        }
        moveAIRandom(buttons);
        return buttons;
    }

    private static JButton [][] moveAIRandom(JButton [][] buttons) {
        // случайный ход компьютера
        int rnd, x, y;
        while (true) {
            rnd = (int) (Math.random() * buttons.length * buttons.length);
            x = rnd / buttons.length;
            y = rnd % buttons.length;
            if (buttons[x][y].getIcon() == ICON_DEFAULT) {
                System.out.printf("Компьютер сделал ход: %d, %d \n", x, y);
                buttons[x][y].setEnabled(false);
                buttons[x][y].setDisabledIcon(ICON_O);
                buttons[x][y].setIcon(ICON_O);
                return buttons;
            }
        }
    }

    private static boolean isWin(ImageIcon ICON_WIN, JButton [][] buttons) {
        // анализ победы
        // при добавлении параметра количества символов подряд
        // надо будет ставить счётчик повторений, анализировать его по строкам
        // и усложнять циклы по проверке диагоналей.
        boolean flagWin;
        // проверка по строкам
        for (int i = 0; i < buttons.length; i++) {
            flagWin = true;
            for (int j = 0; j < buttons.length; j++) {
                if (buttons[i][j].getIcon() != ICON_WIN) flagWin = false;
            }
            if (flagWin) return true;
        }
        // проверка по столбцам
        for (int i = 0; i < buttons.length; i++) {
            flagWin = true;
            for (int j = 0; j < buttons.length; j++) {
                if (buttons[j][i].getIcon() != ICON_WIN) flagWin = false;
            }
            if (flagWin) return true;
        }
        // проверка по основной диагонали
        flagWin = true;
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i][i].getIcon() != ICON_WIN) flagWin = false;
        }
        if (flagWin) return true;
        //поверка по вторичной диагонали
        flagWin = true;
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i][buttons.length - i - 1].getIcon() != ICON_WIN) flagWin = false;
        }
        if (flagWin) return true;
        return false;
    }


    public static void main(String[] args) {
        new Window();
    }
}
