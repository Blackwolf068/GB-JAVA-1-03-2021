package Lesson7;

public class Cat {

    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.satiety = false;
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (p.getFood() >= this.appetite && !this.satiety) {
            this.satiety = true;
            p.decreaseFood(appetite);
        }/* else {
            System.out.println("Коту " + this.name + " не хватает еды в тарелке.");
        }*/
    }

    public void catInfo(){
        if (this.satiety) {
            System.out.println("Котик " + this.name + " съел " + this.appetite + " еды и сыт.");
        } else {
            System.out.println("Котику " + this.name + " не хватило еды в тарелке и он остался голоден.");
        }
    }
}
