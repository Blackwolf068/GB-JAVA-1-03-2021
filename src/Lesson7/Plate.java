package Lesson7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }

    public void increaseFood(int n) {
        food += n;
        System.out.println("В тарелку добавили " + n + " еды, там стало " + food);
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public int getFood() {
        return this.food;
    }

}
