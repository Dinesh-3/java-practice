package com.dinesh.collections;

import com.dinesh.object.Employee;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueuePractice {
    public static void main(String[] args) {
        Employee e1 = new Employee("Dinesh", "I", 93);
        Employee e2 = new Employee("Ram", "D", 98);
        Employee e3 = new Employee("Hari", "W", 94);

        Queue<Employee> queue = new PriorityQueue<>(Comparator.comparingInt(Employee::getRank).reversed());
        queue.add(e1);
        queue.add(e2);
        queue.add(e3);

        Employee employee = queue.remove();
        System.out.println("employee.getRank() = " + employee.getRank());

    }

}
