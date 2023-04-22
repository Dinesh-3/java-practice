package inheritance;

import inheritance.sub_package.SubClass;

import java.time.LocalDate;
import java.time.Month;

/**
 * static Field, static method, instance are not polymorphic
 * only instance method is polymorphic
 */
public class Main {
    /**
     * Java static block
     * Is used to initialize the static data member.
     * It is executed before the main method at the time of classloading.
     */
    static{
        System.out.println("Static block called before main method");
    }
    static {
        System.out.println("STatic Block 2");
    }
    public static void main(String[] args) throws Throwable {
        System.out.println("MAIN method called");
        SubClass subClass = new SubClass();
//        subClass.getDefaultField(); // Throw Compile time error| 'getDefaultField()' is not public in 'inheritance.sub_package.SubClass'. Cannot be accessed from outside package
//        subClass.getProtectedField(); // 'getProtectedField()' has protected access in 'inheritance.sub_package.SubClass'

        User student = new Student("Dinesh", "I", LocalDate.of(2017, Month.JUNE, 1));
        String fullName = student.getFullName();
        System.out.println("fullName = " + fullName);
        System.out.println("student = " + student);
//        System.out.println("student.getFinalYear() = " + student.getFinalYear());
//        System.out.println("Batch: "+student.getBatch());

//        student.finalize(); // Garbage Collector
        System.out.println("student.className = " + student.className);
        System.out.println("student.getClassName() = " + student.getClassName());

        System.out.println("model.User.getStaticClass() = " + User.getStaticClass());
        int index = Entity.getIndex();
        System.out.println("index = " + index);
        int id = student.getId();
        System.out.println("id = " + id);

        User entity = new Student("Dinesh", "I", LocalDate.of(2017, Month.JUNE, 1));
        System.out.println("User.staticClass = " + User.staticClass);
        System.out.println("entity.getClassName() = " + entity.getClassName());
    }
}
