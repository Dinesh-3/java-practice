package collections;

import dataStructure.HashTable;
import io.Customer;

import java.time.LocalDate;
import java.util.*;

public class MapPractise {
    public static void main(String[] args) {

        /**
         *          HashMap
         * Points:
         *  1. Initial Capacity 16
         *  2. Not Thread safe
         *  3. Allow one null key and multiple null values
         */
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Dinesh");
        hashMap.put(2, "Babu");
        hashMap.put(2, "Babu K"); // overrides value if key already exist

        hashMap.putIfAbsent(1, "Dinesh I"); // only put if key not exist
        String getOrDefault = hashMap.getOrDefault(3, "N/A");
        System.out.println("getOrDefault = " + getOrDefault);

        System.out.println("hashMap.containsKey(1) = " + hashMap.containsKey(1)); // 0(1)
        System.out.println("hashMap.containsValue(\"dinesh\") = " + hashMap.containsValue("dinesh")); // Case Sensitive -> 0(n)

        System.out.println("hashMap = " + hashMap);

        /**
         *      HashTable
         * Points:
         *  1. Doesn’t allow any null key or value
         *  2. Synchronized thread safe
         */
        Hashtable<Integer, String> hashTable = new Hashtable<>();
        hashTable.put(0, "Dinesh");

        /**
         *
         *      TreeMap implements SortedMap
         *      public interface SortedMap<K,V> extends Map<K,V>
         * Points:
         *  1. Uses Red Black Tree
         *  2. Sort the elements based on key
         *  3. Doesn't allow null key or value
         */

        SortedMap<Integer, String> sortedMap = new TreeMap<>();
        sortedMap.put(2, "Dinesh");
        sortedMap.put(1, "Rahul");
        sortedMap.put(3, "Balaji");
//        sortedMap.put(null, "unknown"); // Throws error
//        sortedMap.put(4, null); // Throws error
        System.out.println("sortedMap = " + sortedMap);

        var c1 = new Customer("Dinesh", "I", "Male", "India", (byte) 21, LocalDate.now(), 1212);
        var c2 = new Customer("Ram", "V", "Male", "India", (byte) 20, LocalDate.now(), 1213);

        Map<Integer, Customer> map = new HashMap<>();
        map.put(c1.getId(), c1);
        map.put(c2.getId(), c2);

        var exists = map.containsKey(1212);

        var unknown = new Customer("Unknown", "V","Male", "India", (byte) 20, LocalDate.now(), 1214);
        var customer = map.get(1212);
        customer = map.getOrDefault(1111, unknown);

        map.replace(1111, unknown);
        System.out.println("map = " + map);
        for (var key : map.keySet())
            System.out.println(key);

        for (var value : map.values())
            System.out.println(value);

        for (var entry : map.entrySet())
            System.out.println(entry);
    }
}
