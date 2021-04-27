package Lesson6;

public class Cat extends Animal {
    int runLimit = 200;
    int swimLimit = 0;


    @Override
    public void run(int s) {
        if (s >= 0) {
            if (s <= runLimit) {
                System.out.println(this.name + " пробежал " + s + " метров");
            } else {
                System.out.println(this.name + " пробежал 200 метров и дальше бежать не захотел.");
            }
        } else {
            System.out.println("Коты бегают только вперёд.");
        }
    }

    @Override
    public void swim(int s) {
        System.out.println(this.name + " не хочет плавать.");
    }
}
