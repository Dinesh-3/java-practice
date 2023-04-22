package collections;

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
         *  3. Allows one null key and multiple null values
         *  HashMap contains an array of the nodes, and the node is represented as a class. It uses an array and LinkedList data structure
         *
         *  If we Map Key is a class object. It uses hasCode method to generate index
         *  So we need to override equals and hashcode methods inorder to get same result if object data is same
         *
         *  In Java 16 record by default creates equals and hashcode implementation based on the data
         *  So no need to override
         */
        System.out.println("--- HASH MAP ---");
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Dinesh");
        hashMap.put(2, "Babu");
        hashMap.put(2, "Babu K"); // overrides value if key already exist
        hashMap.putIfAbsent(1, "Dinesh I"); // only put if key not exist

        System.out.println("hashMap.get(2) = " + hashMap.get(2));
        String getOrDefault = hashMap.getOrDefault(3, "N/A");
        System.out.println("getOrDefault = " + getOrDefault);

        Set<Integer> keySet = hashMap.keySet();
        System.out.println("keySet = " + keySet);

        Collection<String> values = hashMap.values();
        System.out.println("values = " + values);

        Set<Map.Entry<Integer, String>> entrySet = hashMap.entrySet();
        System.out.println("entrySet = " + entrySet);

        System.out.println("hashMap.containsKey(1) = " + hashMap.containsKey(1)); // 0(1)
        System.out.println("hashMap.containsValue(\"dinesh\") = " + hashMap.containsValue("dinesh")); // Case Sensitive -> 0(n)

        System.out.println("hashMap.isEmpty() = " + hashMap.isEmpty());
        System.out.println("hashMap.size() = " + hashMap.size());
        hashMap.clear();

        System.out.println("hashMap = " + hashMap);

        /**
         *      HashTable
         * public class Hashtable<K,V>
         *     extends Dictionary<K,V>
         *     implements Map<K,V>, Cloneable, java.io.Serializable
         *
         * Points:
         *  1. Not allow any null key or value
         *  2. Synchronized thread safe
         */
        System.out.println("--- HASH TABLE ---");
        Hashtable<Integer, String> hashTable = new Hashtable<>();
        hashTable.put(0, "Dinesh");
        Enumeration<String> elements = hashTable.elements();
        System.out.println("elements = " + elements);

        /**
         *
         * TreeMap implements SortedMap
         * public interface SortedMap<K,V> extends Map<K,V>
         * Points:
         *  1. Uses Red Black Tree
         *  2. Sort the elements based on key
         *  3. Doesn't allow null key or value
         */
        System.out.println("--- TREE MAP ---");
        SortedMap<Integer, String> sortedMap = new TreeMap<>();
        sortedMap.put(2, "Dinesh");
        sortedMap.put(1, "Rahul");
        sortedMap.put(3, "Balaji");
        sortedMap.put(4, "Ragavan");
//        sortedMap.put(null, "unknown"); // Throws error
//        sortedMap.put(4, null); // Throws error
        System.out.println("sortedMap.firstKey() = " + sortedMap.firstKey());
        System.out.println("sortedMap.lastKey() = " + sortedMap.lastKey());
        System.out.println("sortedMap.values() = " + sortedMap.values());
        System.out.println("sortedMap.isEmpty() = " + sortedMap.isEmpty());
        System.out.println("sortedMap.keySet(); = " + sortedMap.keySet());
        System.out.println("sortedMap.entrySet() = " + sortedMap.entrySet());

        System.out.println("sortedMap = " + sortedMap);

        System.out.println("--- LINKED HASH MAP ---");
        /**
         * LINKED HASH MAP
         * Preserves the insertion order
         *
         */
        LinkedHashMap<Integer, String> linkedHashMapPersons = new LinkedHashMap<>();

        linkedHashMapPersons.put(2, "Dinesh");
        linkedHashMapPersons.put(1, "Rahul");
        linkedHashMapPersons.put(3, "Balaji");
        linkedHashMapPersons.put(4, "Ragavan");
        linkedHashMapPersons.put(1, "Gowtham");
        System.out.println("linkedHashMapPersons = " + linkedHashMapPersons);

        for (Map.Entry<Integer, String> persons : linkedHashMapPersons.entrySet()) {
            System.out.println("persons.getKey() = " + persons.getKey());
        }



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
