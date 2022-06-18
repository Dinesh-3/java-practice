package datastructure;

import java.util.Arrays;

public class DataStructure {
    public static void main(String[] args) {

//        Collections.main();
        System.out.println("5^1 = " +( 5 ^ 1));
        Array<String> array = new Array<>(1);
        array.insert("Dinesh");
        array.insert("Babu");
        array.insert("Babu");
        array.insert("Babu");
        array.insert("4");
        array.insert("Me", 3);
//        array.print();
        System.out.println("array = " + array);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addLast(40);
        linkedList.addFirst(5);
//        linkedList.removeFirst();
//        linkedList.reverse();
//        var list = linkedList.toList();

        System.out.println("list = " + Arrays.toString(linkedList.toList()));

//        System.out.println(linkedList.getKthFromTheEND(5));

//        STACK
//        Stack stack = new Stack();
//
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//        stack.push(40);
//        stack.push(50);
//        stack.push(60);
//        stack.push(70);
//        stack.push(80);
//        stack.push(90);
//        stack.push(100);
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.peek();
//        System.out.println("stack = " + stack);

//        PRIORITY QUEUE
//        PriorityQueue priorityQueue = new PriorityQueue(5);
//        priorityQueue.insert(12);
//        priorityQueue.insert(23);
//        priorityQueue.insert(1);
//        priorityQueue.insert(6);
//        priorityQueue.insert(6);
//
//        System.out.println(priorityQueue);

//        HASH TABLE
//        HashTable hashTable = new HashTable();
//        hashTable.put(3, "Dinesh");
//        hashTable.put(4, "Babu");
//        hashTable.put(2, "Nish");
//        hashTable.put(1, "Pavi");
//
//        var result = hashTable.get(2);
//        hashTable.remove(3);
//        System.out.println("result = " + result);

//        BINARY SEARCH TREE
        BinarySearchTree searchTree = new BinarySearchTree();
        searchTree.insert(3);
        searchTree.insert(2);
        searchTree.insert(6);
        searchTree.insert(7);
        searchTree.insert(1);
        searchTree.insert(4);

//        searchTree.preOrderTraversal();
//        searchTree.inOrderTraversal();
//        searchTree.postOrderTraversal();

//        System.out.println("Height = " + searchTree.height());
//        System.out.println("searchTree.min() = " + searchTree.minVal());
//        var kthNodes = searchTree.getKthNodes(1);
//        System.out.println("kthNodes = " + kthNodes);
//        searchTree.traversLevelOrder();
        //        searchTree.contains(6);
//        System.out.println("searchTree = " + searchTree.contains(33));
//        var result = searchTree.find(2, searchTree.getRoot());

    }
}
