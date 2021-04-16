package Lesson5;

public class HomaWork5 {

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Иванов И.И.", "Инженер", "123@company.com", "89101234567", 25000, 34);
        persArray[1] = new Person("Петров П.П.", "Ведущий инженер", "456@company.com", "89102345678", 30000, 41);
        persArray[2] = new Person("Семёнов С.С.", "Инженер", "789@company.com", "89103456789", 25000, 25);
        persArray[3] = new Person("Викторов В.В.", "Начальник отдела", "741@company.com", "89104567890", 40000, 49);
        persArray[4] = new Person("Андреев А.А.", "Мастер", "852@company.com", "89105678901", 35000, 44);

        for (int i = 0; i < 5; i++) {
            if (persArray[i].getAge() >= 40)
                persArray[i].printPerson();;
        }
    }

}
