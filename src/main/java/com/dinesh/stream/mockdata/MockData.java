package stream.mockdata;

import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import stream.beans.Car;
import stream.beans.Person;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MockData {
    private static List<Person> persons = new ArrayList<>(){{
        add(new Person(1, "Dinesh", "I", "dinesh@gmail.com", "male", 21));
        add(new Person(2, "Ranjith", "R", "ranjith@gmail.com", "male", 21));
        add(new Person(3, "Angella", "D", "angella@gmail.com", "female", 21));
        add(new Person(4, "Shreya", "V", "shreya@gmail.com", "female", 21));
    }};

    private static List<Car> cars = new ArrayList<>(){{
        add(new Car(1, "Honda", "X", "black", 2020, 2_000_000.0));
        add(new Car(1, "Tesla", "X", "red", 2018, 3_000_000.0));
        add(new Car(1, "Ferrari", "D", "yellow", 2020, 2_500_000.0));
        add(new Car(1, "BMW", "V", "white", 2019, 4_000_000.0));
        add(new Car(1, "Tesla", "Y", "white", 2018, 4_000_000.0));

    }};

    public static List<Person> getPeople() throws IOException {
        InputStream inputStream = Resources.getResource("/home/dinesh/Downloads/java_practice/stream/mockdata/people.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<Person>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }

    public static List<Car> getCars() throws IOException {
        InputStream inputStream = Resources.getResource("/home/dinesh/Downloads/java_practice/stream/mockdata/cars.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<Car>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }

}
