package pattern;

/**
 * Docs: https://www.tutorialspoint.com/design_pattern/design_pattern_overview.htm
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Java Design Pattern
         *  Types:
         *      1. Creational
         *      2. Structural
         *      3. Behavioural
         *      4. J2EE Pattern
         *  1. Creational Pattern:
         *      Types:
         *          1. Factory method
         *              In Factory Design Pattern we don't expose the object creation logic and
         *              refer the created object using standard interface. It's also known as virtual constructor.
         *              We pass the class name to the Factory method, will create and return that object
         *          2. Abstract Factory
         *              Is a Factory of Factory class
         *              It is one level higher than factory pattern
         *              Example:
         *                  Trainee Profession and Experienced Profession
         *                  Profession profession = new AbstractFactory("trainee") -> Returns the ProfessionFactory based on
         *                                                                          their need like trainee or experienced
         *                  profession.get("engineer");
         *          3. Builder -> Used to create complex object
         *          4. Prototype -> returns new instances with object cloning
         *          5. Singleton -> Returns only one single object
         *
         */

        // Factory Pattern we get new Instance by passing class Name
        Profession profession = ProfessionFactory.getProfession("doctor"); // return new Docker() object
        Profession teacher = ProfessionFactory.getProfession("teacher");
        String doctor = profession.profession();
        System.out.println("doctor = " + doctor);


        // Prototype pattern
        Profession doctor1 = PrototypeProfession.getNewClone("doctor");
        Profession doctor2 = PrototypeProfession.getNewClone("doctor");
        System.out.println("doctor1 = " + doctor1);
        System.out.println("doctor2 = " + doctor2);

        Profession teacher1 = PrototypeProfession.getNewClone("teacher");
        Profession teacher2 = PrototypeProfession.getNewClone("teacher");
        System.out.println("teacher1 = " + teacher1);
        System.out.println("teacher2 = " + teacher2);

    }
}
