//
//import model.Manager;
//import model.User;
//import utils.Console;
//import utils.GenericList;
//
//import java.text.NumberFormat;
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
////import static tricky.TrickyJava.objectRelation;
//public class Main {
//    /**
//     * JAR -> Java ARchive
//     * WAR -> Web Application Archive or Web Application Resource
//     * EAR -> Enterprise Archive file
//     *
//     * Community Links:
//     * 1. Java Community Process -> https://www.jcp.org/en/home/index
//     * 2. Java Specifications Request
//     *      -> https://stackoverflow.com/questions/9901976/what-is-jsr-and-whats-its-use
//     *      -> https://jcp.org/en/jsr/overview
//     * JAX-RS:
//     *  Jakarta RESTful Web Services . Specifications for building RESTful services.
//     *  Implementation -> RESTEasy, Jersey
//     *      Links -> https://www.baeldung.com/rest-api-jax-rs-vs-spring
//     */
//
//    public static void main(String[] args) {
////        objectRelation();
//
//        Optional.of(null);
//
//        List<Integer> as = new ArrayList<>(List.of(1,2,3,5,4));
//
////        for (int i = 0; i < 10; i++) {
////            as.add(i);
////            as.remove(1);
////        }
//
//        ListIterator<Integer> integerListIterator = as.listIterator(as.size());
//        while (integerListIterator.hasPrevious()){
//            System.out.print(integerListIterator.previous() + " ");
//        }
//        System.out.println();
//
////        model.User user1 = new model.User("Dinesh", "I", (byte) 10);
////        model.User user2 = user1;
////        user1.setAge((byte) 20);
////        System.out.println("user1 = " + user1.getAge());
////        System.out.println("user2 = " + user2.getAge());
//
////        var laptop = new model.Laptop("HP", 100_000, (byte) 8, 512, LocalDateTime.now());
////        String laptopName = laptop.getName();
////        System.out.println(laptopName);
////        LampdaExpression.main();
//        // ThreadPractise.main();
//
//
//        var manager = new Manager("Dinesh", "I", (byte) 20);
//        User user = new User("Dinesh", "I", "2001-06-01");
//        User[] users = { manager, user };
//        String firstName = manager.getFirstName();
//        System.out.println("firstName = " + firstName);
//
//        GenericList<String> genericList = new GenericList<>();
//        genericList.add("Dinesh");
//        genericList.add("I");
//        genericList.add("F");
//
//        String myName = "";
//        for(var item: genericList) {
////            String myName = ""; //Variable 'myName' is already defined in the scope
//            System.out.println("item = " + item);
//        }
//
//    }
//
//    public Optional<?> optionalFeature() {
////        Optional.of("Dinesh"); // Won't accept Null values , will throw error
////        Optional.ofNullable("Dinesh");
////        return Optional.empty();
//        return Optional.of("Dinesh");
//    }
//
//}
