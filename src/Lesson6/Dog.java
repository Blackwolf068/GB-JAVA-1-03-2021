package Lesson6;

public class Dog extends Animal{
    int runLimit = 500;
    int swimLimit = 10;

    @Override
    public void run(int s) {
        if (s >= 0) {
            if (s <= runLimit) {
                System.out.println(this.name + " пробежал " + s + " метров");
            } else {
                System.out.println(this.name + " пробежал 200 метров и дальше бежать не хочет.");
            }
        } else {
            System.out.println("Собаки бегают только вперёд.");
        }
    }

    @Override
    public void swim(int s) {
        if (s >= 0) {
            if (s <= swimLimit) {
                System.out.println(this.name + " проплыл " + s + " метров");
            } else {
                System.out.println("Слишком большая дистанция для заплыва собаки.");
            }
        } else {
            System.out.println("Собаки плавают только вперёд.");
        }

    }
}
