package Lesson6;

public class HomeWork6 {

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.name = "Васька";
        cat1.run(120);
        Cat cat2 = new Cat();
        cat2.name = "Мурзик";
        cat2.swim(5);
        Dog dog1 = new Dog();
        dog1.name = "Тузик";
        Dog dog2 = new Dog();
        dog2.name = "Шарик";
        dog1.run(145);
        dog1.swim(15);
        dog2.swim(8);
    }
}
