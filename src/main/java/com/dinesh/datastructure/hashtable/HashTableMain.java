package com.dinesh.datastructure.hashtable;

/** Cluster -> Set of same thing in ordered
 * Hashing: (given key) % (internal array.length)
 * Collisions:
 * 1. Chaining
 * 2. Open Addressing
 *      1. Linear Probing
 *          -> Probing == searching
 *          Formula: hash(key) + i
 *      2. Quadratic Probing
 *          Formula: hash(key) + i ^ 2
 *          Issue -> Looping happen for same jump
 *      3. Double Hashing
 *          prime -> number less than array length
 *          hash2(key) = prime - (key % prime)
 *          (hash1(key) + i*hash2(key)) % table_size
 */
public class HashTableMain {
    public static void main(String[] args) {
        ChainHashMap map = new ChainHashMap();

        map.put(3, "Dinesh");
        map.put(11, "sdfgsdfg");
        map.put(23, "sdfgsdfg");
        map.put(12, "sdfgsdfg");
        map.put(76, "dfgsdf");
        map.put(4, "sdfgsdfg");
        map.put(8, "dfgsdfg");
        map.put(32, "dfgsdfg");
        map.put(76, "ggggggggggggggg");
        map.put(67, "sdfgdfg");
        map.put(20, "dfgdfg");
        map.put(24, "dfgdfg");
        map.put(66, "dfgdfg");

        System.out.println(map.get(76));
        map.remove(76);
        System.out.println(map.get(76));

    }
}
