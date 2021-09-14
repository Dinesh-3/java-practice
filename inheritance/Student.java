package inheritance;

import java.time.LocalDate;
import java.util.Date;

public class Student extends User {
    private LocalDate joinDate;
    public String className=this.getClass().getName();
    public static String staticClass=Student.class.getName();
    public Student(String firstName, String lastName,LocalDate joinDate) {
        super(firstName, lastName);
        this.joinDate = joinDate;
    }

    @Override
    public String getFullName() {
        return super.getFirstName() + "-" + super.getLastName();
    }

    public int getBatch() {
        return joinDate.getYear();
    }

    public int getFinalYear() {
        return joinDate.plusYears(4).getYear();
//        return joinDate.getYear() + 4;
    }

    @Override
    public String getClassName() {
        return className;
    }

    public static String getStaticClass() {
        return staticClass;
    }
}
