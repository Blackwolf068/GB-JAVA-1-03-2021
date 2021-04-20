package Lesson7;

public class MainClass {

    public static void main(String[] args) {
        Cat[] cats = new Cat[10];
        String catName[] = {"Васька", "Барсик", "Мурка", "Пушистик", "Снежок", "Матильда", "Серый", "Коржик", "Карамелька", "Компот"};
        for (int i = 0; i < 10; i++) {
            cats[i] = new Cat(catName[i], (int) (Math.random() * 10 + 10));
        }
        Plate plate = new Plate(100);
        plate.info();
        for (int i = 0; i < 10; i++) {
            cats[i].eat(plate);
            cats[i].catInfo();
            plate.increaseFood(3);
        }
        plate.info();
    }

}
