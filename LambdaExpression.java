import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LambdaExpression {
    public static void main(String[] args) {
        System.out.println("--- LAMBDA EXPRESSION ---");
        var users = new ArrayList<>(List.of(
                new User("Dinesh", "I", (byte) 21),
                new User("Babu", "K", (byte) 21),
                new User("Babu", "K", (byte) 18),
                new User("Babu", "A", (byte) 18),
                new User("Rahul", "D", (byte) 24),
                new User("Balaji", "D", (byte) 21),
                new User("Ranjith", "D", (byte) 23),
                new User("Barani", "D", (byte) 21),
                new User("Gowtham", "D", (byte) 21),
                new User("Logesh", "D", (byte) 16),
                new User("Nishanth", "D", (byte) 20),
                new User("Pavithran", "D", (byte) 21),
                new User("Naveen", "D", (byte) 18),
                new User("Mohan", "D", (byte) 19),
                new User("Sathi", "D", (byte) 22),
                new User("Murali", "D", (byte) 22),
                new User("Alfin Thomas", "D", (byte) 20),
                new User("Alavi", "D", (byte) 21),
                new User("Tony", "D", (byte) 24),
                new User("Abdul Aseef", "D", (byte) 22),
                new User("Vasanth", "D", (byte) 25),
                new User("Vasanth Kumar", "D", (byte) 22),
                new User("Mathiraj", "D", (byte) 26),
                new User("Saran", "D", (byte) 21),
                new User("Harish", "D", (byte) 23))
        );
        var numbers = new ArrayList<>(List.of(3, 2, 4, 8, 1, 5, 9, 6, 7, 0));

        Consumer<String> print = content -> {
            content = content.toUpperCase();
            System.out.println("content = " + content);
        };
        Supplier<Double> getRandom = Math::random;

        Function<String, String> toUppercase = String::toUpperCase;
        IntFunction<Double> intToDouble = arg -> (double) arg;
        ToIntFunction<Float> floatToIntFunction = Math::round;
        DoubleToIntFunction doubleToIntFunction = arg -> (int) Math.round(arg);
        String dinesh = toUppercase.andThen(i -> { System.out.println(i); return i+ " I"; }).apply("Dinesh");
        System.out.println("dinesh = " + dinesh);


        BinaryOperator<Integer> add = (a, b) -> a + b;
        Function<Integer, Integer> square = a -> a * a;

//        System.out.println("add.andThen(square) = " + add.andThen(square).apply(1,1));

        UnaryOperator<Integer> addOne = n -> n + 1;
        UnaryOperator<Integer> squareOfNumber = n -> n * n;

//        System.out.println("addOne.andThen(square).apply(1) = " + addOne.andThen(square).apply(1));

        Predicate<String> isValidName = message -> message.length() > 5;
        boolean isValid = isValidName.test("DInesh");
        System.out.println("isValid = " + isValidName.negate().or(m -> m.startsWith("D")).test("Dinesh"));
        System.out.println("dinesh = " + doubleToIntFunction.applyAsInt(1.2F));
//        users.forEach(print.andThen(message -> System.out.println("HELLO")));
//        users.forEach(print);

        int page = 1;
        int limit = 2;

        users.stream()
                .distinct()
                .sorted(Comparator.comparing(User::getFirstName))
                .peek(LambdaExpression::accept) // Used to log each element
                .map(user -> user.getFirstName().toUpperCase())
//                .filter(name -> name.startsWith("B"))
//                .count()
//                .skip((page - 1) * limit)
//                .limit(limit)
                .forEach(System.out::println);
        var result = numbers.stream()
//                .count()
//                .anyMatch(number -> number > 5) // RETURNS BOOLEAN
//                .allMatch(number -> number > 5) // RETURNS BOOLEAN
//                .noneMatch(number -> number > 5) // RETURNS BOOLEAN True if none of the objects are doesn't match the requirement
//                .findFirst().get() // RETURNS FIRST ELEMENT IN STREAM
//                .findAny().get() // RETURNS ANY ELEMENT IN STREAM

//                FIND MIN AND MAX
//                .max(Comparator.comparing(a -> a )).get()
//                .min(Comparator.comparing(a -> a )).get();

//               REDUCE
//                .reduce(Integer::sum).orElse(0);
//                .reduce(0, Integer::sum);
                ;
        System.out.println("result = " + result);

//        Collector

        var collect = numbers.stream()
//                .collect(Collectors.toList());
                .collect(Collectors.toMap(a -> a, a -> a
//                        ,(name1, name2) -> name1 + name2 // this function used for same key repeated
                ));
//                .collect(Collectors.toSet());
//                .collect(Collectors.summingInt(a -> a));
//                .collect(Collectors.summarizingInt(a -> a));
        System.out.println("Collected = " + collect);
//        var collectString = String.join(",", users);
        var collectString = users.stream()
                .map(User::getFirstName)
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println("collectString = " + collectString);
        System.out.println("--- END ---");

    }


    private static void accept(User peeked) {
        System.out.println("peeked = " + peeked);
    }
}