package stream.examples;

import stream.beans.Car;
import stream.beans.Person;
import stream.beans.PersonDTO;
import stream.mockdata.MockData;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransformationsMapAndReduce {
    public static void main(String[] args) {
        TransformationsMapAndReduce mapAndReduce = new TransformationsMapAndReduce();
        mapAndReduce.reduce();
    }
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();

        Function<Person, PersonDTO> personPersonDTOFunction = person ->
                new PersonDTO(
                        person.getId(),
                        person.getFirstName(),
                        person.getAge());

        List<PersonDTO> dtos = people.stream()
                .filter(person -> person.getAge() > 20)
                .map(PersonDTO::map)
                .collect(Collectors.toList());

        dtos.forEach(System.out::println);

    }

    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
        double avg = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
        System.out.println(avg);
    }

    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
        int sum = Arrays.stream(integers).reduce(0, Integer::sum);
        int sub = Arrays.stream(integers).reduce(0, (a, b) -> a - b);
        System.out.println(sum);
        System.out.println(sub);
    }
}

