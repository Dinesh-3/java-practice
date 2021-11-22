package stream.examples;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransformationsWithFlatMap {
    public static void main(String[] args) {
        TransformationsWithFlatMap flatMap = new TransformationsWithFlatMap();
        flatMap.flatMapWithOptionals();
    }
    private static final List<List<String>> arrayListOfNames = List.of(
            List.of("Mariam", "Alex", "Ismail"),
            List.of("John", "Alesha", "Andre"),
            List.of("Susy", "Ali")
    );

    void setUp() {
        System.out.println(arrayListOfNames);
    }

    public void withoutFlatMap() throws Exception {
        // [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
        List<String> names = new ArrayList<>();
        for (List<String> strings : arrayListOfNames) {
            names.addAll(strings);
        }
        System.out.println(names);
    }

    public void withFlatMap() throws Exception {
        // [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
        List<String> names = arrayListOfNames.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(names);
    }

    public void flatMapWithOptionals() {
        List<Optional<String>> optionals = List.of(
                Optional.of("Amigos"),
                Optional.of("Code"),
                Optional.of(""),
                Optional.ofNullable(null)
        );

        List<String> list = optionals.stream()
                .flatMap(s -> s.stream())
                .collect(Collectors.toList());

        System.out.println(list);
    }
}

