package OOP;

import java.time.LocalDate;

public class OOPMain {
    public static void main(String[] args) {
        Person dinesh = new Person("Dinesh", "Iyyandurai", LocalDate.of(2000, 7, 25));

        int age = dinesh.getAge();

        System.out.println("age = " + age);
    }
}
