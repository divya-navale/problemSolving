import java.util.*;

public class DataStructures {

    // remove - remove the element and returns head if present else throws exception
    // poll - remove the element if present else returns null

    public static void arrayOperations() {
        int[] array = {1, 2, 3, 4, 5};
        Arrays.sort(array);
        Arrays.fill(array, 0);
        Arrays.sort(array, Collections.reverseOrder());
        System.out.println("Array length: " + array.length);
        System.out.println("Element at index 2: " + array[2]);
    }

    public static void arrayListOperations() {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Collections.reverse(arrayList);
        arrayList.add(6);
        System.out.println("ArrayList size: " + arrayList.size());
        System.out.println("Element at index 2: " + arrayList.get(2));
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head = new Node(10); // Create a new node
    head.next = new Node(20); // Link to another node

    public static void linkedListOperations() {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        linkedList.addFirst(0);
        linkedList.addLast(6);
        linkedList.add(10); // Adds to the end
        linkedList.removeFirst();
        linkedList.removeLast();
        boolean contains = linkedList.contains(10);
        System.out.println("LinkedList size: " + linkedList.size());
        System.out.println("First element: " + linkedList.getFirst());
        System.out.println("Last element: " + linkedList.getLast());
    }

    class DoublyNode {
        int data;
        DoublyNode next;
        DoublyNode prev;

        DoublyNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    DoublyNode head = new DoublyNode(10); // Create a new node 
    head.next = new DoublyNode(20); // Link to another node
    head.next.prev = head; // Link back to the previous node

    public static  void dequeAsStackOperations() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println("Deque size: " + deque.size());
        System.out.println("Top element: " + deque.peek());
        deque.pop();
        System.out.println("Top element after pop: " + deque.peek());
        if(deque.isEmpty()){
            System.out.println("Deque is empty");
        }
    }

    public static void stackOperations() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack size: " + stack.size());
        System.out.println("Top element: " + stack.peek());
        stack.pop();
        System.out.println("Top element after pop: " + stack.peek());
    }

    public static void queueOperations() {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        queue.add(6);
        System.out.println("Queue size: " + queue.size());
        System.out.println("Head element: " + queue.peek());
        queue.poll();
        queue.remove();
        System.out.println("Head element after poll: " + queue.peek());
        isEmpty = queue.isEmpty();
    }

    public static void priorityQueueOperations() {
        // Min heap
        PriorityQueue<Integer> minheap = new PriorityQueue<>(Arrays.asList(5, 1, 3, 2, 4));
        minheap.add(6);
        System.out.println("PriorityQueue size: " + minheap.size());
        System.out.println("Head element: " + minheap.peek());
        minheap.poll();
        minheap.remove();
        if(minheap.isEmpty()){
            System.out.println("PriorityQueue is empty");
        }

        // Max heap
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public static void hashMapOperations() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "one");
        hashMap.put(2, "two");
        hashMap.put(3, "three");
        System.out.println("HashMap size: " + hashMap.size());
        System.out.println("Value for key 2: " + hashMap.get(2));
        System.out.println("HashMap contains key 2: " + hashMap.containsKey(2));
        System.out.println("HashMap contains 10: " + hashMap.containsValue(10));
        hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        hashMap.isEmpty();
        Set<Integer> keys = hashMap.keySet(); // Get all keys
        List<Integer> values = new ArrayList<>(hashMap.values()); // Get all values
        List<Integer> entries = new ArrayList<>(hashMap.keySet()); // Get all keys
    }

    public static void hashSetOperations() {
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        hashSet.add(6);
        set.remove(10);
        System.out.println("HashSet size: " + hashSet.size());
        System.out.println("HashSet contains 3: " + hashSet.contains(3));
        hashSet.clear(); // Clear all elements
    }

    public static void treeSetOperations() {
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(5, 1, 3, 2, 4));
        treeSet.add(6);
        System.out.println("TreeSet size: " + treeSet.size());
        System.out.println("First element: " + treeSet.first());
    }

    public static void treeMapOperations() {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "one");
        treeMap.put(2, "two");
        treeMap.put(3, "three");
        System.out.println("TreeMap size: " + treeMap.size());
        System.out.println("Value for key 2: " + treeMap.get(2));
    }

    class Graph {
        int vertices;
        LinkedList<Integer>[] adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
    }

    void addEdge(int src, int dest) {
        adjList[src].add(dest); // Add directed edge
    }
}