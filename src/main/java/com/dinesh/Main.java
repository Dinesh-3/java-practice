package com.dinesh;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    @Component
    class Address {
        private String addressLine1;
    }

    @Component
    @Scope("singleton")
    class Person {
        private String employeeId;
        private String firstName;
        private String lastNa;
        private List<Address> addresses;
    }



    static class Person {
        private String name;
        private String place;

        public Person(String name, String place) {
            this.name = name;
            this.place = place;
        }
    }

    public static void main(String[] args) {
        /**
         *
         *
         *  employee
         *  id, name, email
         *
         *  salaree, tax,
         *
         *  processed_salary
         *
         *  salary_status
         *
         *  SELECT TOP 10
         *
         *  10,
         *
         *  10kb
         *
         *  100kb
         *
         * 1000000 / 100
         *
         * 10
         *
         * 1GB
         *
         * 1000 * 1000 /
         *
         * 1000000 * 10KB
         *
         *
         */
    }

    private static void filterPerson() {


        //'dileep', 'dev'

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Murail", "Karnataka"));
        persons.add(new Person("Dinesh", "Tamilnadu"));
        persons.add(new Person("Dev", "Tamilnadu"));
        persons.add(new Person("Raj", "Karnataka"));

        List<Person> personsFromKarnataka = new ArrayList<>();
        List<Person> personsFromTamilNadu = new ArrayList<>();

        // persons.stream().collect(Collectors.groupingBy(()))


//        Executors.newFixedThreadPool()

        /**
         *
         *
         *
         *
         */


        /**
         *
         *
         *  {
         *
         *      // murali,
         *      //
         *
         *      //
         *
         *      1, 5, 8,
         *
         *      /
         *         Total Sent - 5, Pending -
         *
         *
         *
         *      /
         *
         *
         *  }
         *
         *
         *
         *
         *
         */}

}