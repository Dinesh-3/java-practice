package com.dinesh.reflection;

import com.dinesh.object.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

public class Reflection {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
//        personClass.getConstructors()[0].newInstance();
        Person personObject = new Person("Dinesh", "Iyyandurai", LocalDate.of(2000, 07, 25));
//        personObject.getClass();
        Method[] methods = personClass.getMethods();

        Optional<Method> optionalGetAgeMethod = Arrays.stream(methods).filter(method -> {
//            System.out.println("method.getName() = " + method.getName());
            return method.getName().equals("getAge");
        }).findFirst();

        Object age = optionalGetAgeMethod.get().invoke(personObject);

        System.out.println("age = " + age);
    }
}
