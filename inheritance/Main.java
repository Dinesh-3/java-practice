package inheritance;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    /**
     * Java static block
     * Is used to initialize the static data member.
     * It is executed before the main method at the time of classloading.
     */
    static{
        System.out.println("Static block called before main method");
    }
    public static void main(String[] args) throws Throwable {
        System.out.println("MAIN method called");
        User student = new Student("Dinesh", "I", LocalDate.of(2017, Month.JUNE, 1));
        String fullName = student.getFullName();
        System.out.println("fullName = " + fullName);
        System.out.println("student = " + student);
//        System.out.println("student.getFinalYear() = " + student.getFinalYear());
//        System.out.println("Batch: "+student.getBatch());

//        student.finalize(); // Garbage Collector
        String className = student.className;
        System.out.println("className = " + className);
        System.out.println("student.getClassName() = " + student.getClassName());

        System.out.println("User.getStaticClass() = " + User.getStaticClass());
        int index = Entity.getIndex();
        System.out.println("index = " + index);
        int id = student.getId();
        System.out.println("id = " + id);
    }
}
