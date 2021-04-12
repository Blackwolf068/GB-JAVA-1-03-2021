package Lesson5;

public class Person {
    private String name = new String();
    private String position = new String();
    private String email = new String();
    private String phone = new String();
    private int salary;
    private int age;

    public void printPerson() {
        System.out.println("Сотрудник - " + this.name +
                ", должность - " + this.position +
                ", email - " + this.email +
                ", телефон - " + this.phone +
                ", оклад - " + this.salary + " рублей" +
                ", возраст - " + this.age + " лет.");
    }

    public Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

}
