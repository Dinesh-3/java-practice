package stream;

import model.User;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 0101
 * 1000
 * 1101
 * References:
 * 1. https://stackoverflow.com/questions/5894818/how-to-sort-arraylistlong-in-decreasing-order#comment6782749_5894842
 */

public class StreamMain {
    public static void main(String[] args) {
        System.out.println("--- LAMBDA EXPRESSION ---");
        var users = new ArrayList<>(List.of(
                new User("Dinesh", "I", "2001-04-25"),
                new User("Babu", "K", "2001-04-25"),
                new User("Babu", "K", "2004-04-25"),
                new User("Babu", "A", "2004-04-25"),
                new User("Rahul", "D", "1998-04-25"),
                new User("Balaji", "D", "2001-04-25"),
                new User("Ranjith", "D", "1999-04-25"),
                new User("Barani", "D", "2001-04-25"),
                new User("Gowtham", "D", "2001-04-25"),
                new User("Logesh", "D", "2006-04-25"),
                new User("Nishanth", "D", "2002-04-25"),
                new User("Pavithran", "D", "2001-04-25"),
                new User("Naveen", "D", "2004-04-25"),
                new User("Mohan", "D", "2003-04-25"),
                new User("Sathi", "D", "2000-04-25"),
                new User("Murali", "D", "2000-04-25"),
                new User("Alfin Thomas", "D", "2002-04-25"),
                new User("Alavi", "D", "2001-04-25"),
                new User("Tony", "D", "1998-04-25"),
                new User("Abdul Aseef", "D", "2000-04-25"),
                new User("Vasanth", "D", "1997-04-25"),
                new User("Vasanth Kumar", "D", "2000-04-25"),
                new User("Mathiraj", "D", "1996-04-25"),
                new User("Saran", "D", "2001-04-25"),
                new User("Harish", "D", "1999-04-25")
                ));

        User.covertAgeIntoDateOfBirthAndCopy(users);

        var numbers = new ArrayList<>(List.of(3, 2, 4, 8, 1, 5, 9, 6, 7, 0));
        System.out.println("numbers = " + numbers);

        Consumer<String> print = content -> {
            content = content.toUpperCase();
            System.out.println("content = " + content);
        };
        Supplier<Double> getRandom = Math::random;
        System.out.println("getRandom.get() = " + getRandom.get());
        
        Function<String, String> toUppercase = String::toUpperCase;

        IntFunction<Double> intToDouble = arg -> (double) arg;
        DoubleFunction<Integer> doubleToFunction = arg -> (int) arg;
        LongFunction<Integer> longToInteger = arg -> (int) arg;

        ToIntFunction<Float> floatToIntFunction = Math::round;
        ToDoubleFunction<Integer> integerToDoubleFunction = arg -> (double) arg;
        ToLongFunction<Double> doubleToLongFunction = Double::longValue;

        DoubleToIntFunction doubleToIntFunction = arg -> (int) Math.round(arg);
        System.out.println("doubleToIntFunction.applyAsInt(1.2F) = " + doubleToIntFunction.applyAsInt(1.2F));
        IntToDoubleFunction intToDoubleFunction = arg -> arg;
//        System.out.println("intToDoubleFunction.applyAsDouble(12) = " + intToDoubleFunction.applyAsDouble(12));
        String dinesh = toUppercase.andThen(i -> {
            System.out.println(i);
            return i + " I";
        }).apply("Dinesh");
        System.out.println("dinesh = " + dinesh);
        Double DoubleConverted = intToDouble.apply(10);

        BinaryOperator<Integer> add = Integer::sum;
        Function<Integer, Integer> square = a -> a * a;

        System.out.println("add.andThen(square) = " + add.andThen(square).apply(1,1));

        UnaryOperator<Integer> addOne = n -> n + 1;
        UnaryOperator<Integer> squareOfNumber = n -> n * n;

        System.out.println("addOne.andThen(square).apply(1) = " + addOne.andThen(square).apply(1));
        System.out.println("addOne.compose(square).andThen(square).apply(2) = " + addOne.compose(square).andThen(square).apply(2));

        Predicate<String> isValidName = message -> message.length() > 5;
        BiPredicate<String, String> isEqual = String::equals;
        IntPredicate isFive = number -> number == 5; // Also have DoublePredicate, LongPredicate

        boolean isValid = isValidName.test("Dsh"); // and, or, negate,test
        System.out.println("isValid = " + isValidName.negate().or(m -> m.startsWith("D")).test("Dinesh"));
        System.out.println("isFive.test(5); = " + isFive.test(5));
//        users.forEach(print.andThen(message -> System.out.println("HELLO")));
//        users.forEach(print);

        int page = 1;
        int limit = 2;

        // Manual Comparing setup
        users.sort(model.User::compareTo);
        System.out.println(users);

        var userStream = users.stream()
                .distinct()
//                .sorted(Comparator.comparing(User::getFirstName))
                .sorted(
                        Comparator.comparing(User::getAge)
                                .reversed()
                                .thenComparing(User::getFirstName)
                )
//                .peek(stream.StreamMain::accept) // Used to log each element
                .map(user -> user.getFirstName().toUpperCase())
//                .filter(name -> name.startsWith("B"))
//                .count()
//                .skip((page - 1) * limit)
//                .limit(limit)
//                .max(Comparator.comparing(model.User::getAge)) //.get()
                .collect(
                        Collectors.groupingBy(
                                (item) -> item.startsWith("a"),
//                                Collectors.counting()
//                                Collectors.joining(",")
//                                Collectors.toList()
                                Collectors.mapping((item) -> item, Collectors.joining(","))
                        )
                )

//                .forEach(System.out::println)
                ;
        System.out.println("userStream = " + userStream);
        /**
         * FlatMap
         */
        List<String> country = Stream.of(
                        Arrays.asList("Colombia", "Finland", "Greece", "Iceland", "Liberia", "Mali", "Mauritius"),
                        Arrays.asList("Peru", "Serbia", "Singapore", "Turkey", "Uzbekistan", "Yemen", "Zimbabwe", "Greece", "Iceland"))
                .flatMap(strings -> strings.stream())
                .collect(Collectors.toList());

        List<String> fruits = new ArrayList<>(List.of("Strawberries", "Fig", "pine apple", "Dragon", "apple", "orange", "banana", "mango", "grape"));
        List<String> sortedFruit = fruits.stream()
                .sorted(
                        Comparator.comparing(String::length) // First by length and then by alphabetical order
                                .thenComparing(a -> a)
                ) // ascending order
//                .sorted(Comparator.comparingInt((String s) -> s.length()).reversed()) // descending order
//                .sorted((a, b) -> a.length() - b.length()) // ascending order
//                .sorted((a, b) -> b.length() - a.length()) // descending order
//                .sorted((a, b) -> a.length() < b.length() ? -1: 1) // ascending order
//                .sorted((a, b) -> {
//                    System.out.printf("%s, %s = %s\n", a, b, a.length() > b.length() ? -1: 1);
//                    return a.length() > b.length() ? -1: 1;
//                }) // descending order
                .collect(Collectors.toList());

        System.out.println("sortedFruit = " + sortedFruit);

        var result = numbers.stream()
//                .count()
//                .anyMatch(number -> number > 5) // RETURNS BOOLEAN
//                .allMatch(number -> number > 5) // RETURNS BOOLEAN
//                .noneMatch(number -> number > 5) // RETURNS BOOLEAN True if none of the objects are doesn't match the requirement
//                .findFirst().get() // RETURNS FIRST ELEMENT IN STREAM , Always gives the computed result of the firstElement
//                .findAny().get() // RETURNS ANY ELEMENT IN STREAM , Parallel stream

//                FIND MIN AND MAX
//                .max(Comparator.naturalOrder())
//                .max((a, b) -> a.compareTo(b))
//                .max((x,y) -> x-y)
//                .max((x,y) -> {
//                    System.out.println("x, y = " + x + " " + y + " " + ((x < y) ? -1 : (x == y) ? 0 : 1));
//                    return (x < y) ? -1 : (x == y) ? 0 : 1;
//                })
//                .max((x, y) -> x - y) // maxValueComes
//                .max((x,y) -> y - x) // minValueComes
//                .min(Comparator.comparing(a -> a ))
//                .get();
//                .isPresent(); Check given value is Present or not
//                .isEmpty(); Opposite of isPresent
//               REDUCE
//                .reduce((a1, b1) -> Integer.sum(a1, b1));
                .reduce(0, Integer::sum); // param 1 is start value
        ;
//        List<String> objects = Collections.emptyList();
        System.out.println("result = " + result);

//        WHILE
        System.out.println("\n--- WHILE ---");
        numbers.stream()
//                .takeWhile(num -> num < 5)
//                .dropWhile(num -> num < 5) // Drops numbers that are less than 5
//                .forEach(System.out::println);
        ;
        System.out.println();
//        Collector

        var collect = numbers.stream()
//                .collect(Collectors.toList())
//                .collect(Collectors.toMap(a -> a, a -> a
//                        ,(name1, name2) -> name1 + name2 // this function used for same key repeated
//                ))
//                .collect(Collectors.toSet())
//                .collect(Collectors.averagingInt(a -> a))
                .mapToInt(a -> a)
//                .sum()
                .mapToLong(a -> a)
//                .mapMulti()
//                .collect(Collectors.summingInt(a -> a))
//                .collect(Collectors.summarizingInt(a -> a))
                ;
        /**
         * Sample - IntSummaryStatistics{count=10, sum=45, min=0, average=4.500000, max=9}
         * Methods
         * .getAverage()
         * .getCount()
         * .getSum()
         * getMin()
         * getMax()
         * combine(IntSummaryStatistics other) -> To combine with other IntStatistics
         */
        System.out.println("Collected = " + collect);
//        var collectString = String.join(",", users);
        var collectString = users.stream()
                .map(User::getFirstName)
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println("collectString = " + collectString);
        System.out.println("--- END ---");

        var numberGreaterThan5 = numbers.stream().
                map(a -> a)
                .collect(
                        Collectors.partitioningBy(
                                (number) -> number > 5,
//                                Collectors.toList()
//                                Collectors.counting()
                                Collectors.mapping(a -> String.valueOf(a), Collectors.joining(","))
                        )
                );
        System.out.println("numberGreaterThan5 = " + numberGreaterThan5);

        BinaryOperator<Integer> addTwo = (a, b) -> a + b; // (int a, int b) -> a + b specifying type also valid but optional
//        int sum = addTwo.add(1, 2);
//        System.out.println("sum = " + sum);
    }


    private static void accept(User peeked) {
        System.out.println("peeked = " + peeked);
    }

    private static void flatMap() {
        //creating ArrayList
        List<String> productlist1 = Arrays.asList("Printer", "Mouse", "Keyboard", "Motherboard");
        List<String> productlist2 = Arrays.asList("Scanner", "Projector", "Light Pen");
        List<String> productlist3 = Arrays.asList("Pen Drive", "Charger", "WIFI Adapter", "Cooling Fan");
        List<String> productlist4 = Arrays.asList("CPU Cabinet", "WebCam", "USB Light", "Microphone", "Power cable");
        List<List<String>> allproducts = new ArrayList<List<String>>();
        //adding elements to the list
        allproducts.add(productlist1);
        allproducts.add(productlist2);
        allproducts.add(productlist3);
        allproducts.add(productlist4);
        //creating a list of all products
        List<String> listOfAllProducts = new ArrayList<String>();
        //for each loop iterates over the list
        for (List<String> pro : allproducts) {
            for (String product : pro) {
                //adds all products to the list
                listOfAllProducts.add(product);
            }
        }
        System.out.println("List Before Applying mapping and Flattening: \n");
        //prints stream before applying the flatMap() method
        System.out.println(listOfAllProducts);
        System.out.println();

        //creats a stream of elemnts using flatMap()
        List<String> flatMapList = allproducts.stream()
//                                                .flatMap(List::stream) // or Collection::Stream
                .flatMap(strings -> strings.stream())
                .collect(Collectors.toList());
        System.out.println("List After Applying Mapping and Flattening Operation: \n");
        //prints the new stream that we get after applying mapping and flattening
        System.out.println(flatMapList);
    }

}

