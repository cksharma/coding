package hard;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class LinkedList {
        int key;
        int value;
        LinkedList next;
        LinkedList prev;
        LinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    LinkedList head;
    LinkedList tail;
    Map<Integer, LinkedList> cache;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        LinkedList node = cache.get(key);
        if (node == null) return -1;
        deleteNode(node);
        prependNode(node);
        cache.put(key, node);
        return node.value;
    }

    public void set(int key, int value) {
        if (cache.size() == capacity && cache.containsKey(key) == false) {
            removeLeastRecentlyUsed();
        }
        LinkedList node;
        if (cache.containsKey(key)) {
            node = cache.get(key);
            deleteNode(node);
            node.value = value;
        } else {
            node = new LinkedList(key, value);
        }
        prependNode(node);
        cache.put(key, node);
    }

    private void deleteNode(LinkedList node) {
        LinkedList prev = node.prev;
        LinkedList next = node.next;
        if (prev != null) {
            prev.next = next;
        } else {
            head = next;
        }

        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev;
            if (prev != null) prev.next = null;
        }

        cache.remove(node.key);
    }

    private void prependNode(LinkedList node) {
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) tail = head;
        cache.put(node.key, node);
    }

    private void removeLeastRecentlyUsed() {
        if (tail == head) {
            if (tail != null) cache.remove(tail.key);
            head = null; tail = null;
        } else {
            LinkedList prev = tail.prev;
            if (prev != null) prev.next = null;
            cache.remove(tail.key);
            tail = prev;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);

        lruCache.set(1, 1);
        lruCache.set(2, 2);
        lruCache.set(3, 3);
        lruCache.set(4, 4);

        System.out.print("from head ");
        printCache(lruCache.head);
        System.out.print("from tail ");
        printCacheTail(lruCache.tail);

        System.out.println(lruCache.get(4));
        System.out.print("from head ");
        printCache(lruCache.head);
        System.out.print("from tail ");
        printCacheTail(lruCache.tail);

        System.out.println(lruCache.get(3));
        System.out.print("from head ");
        printCache(lruCache.head);
        System.out.print("from tail ");
        printCacheTail(lruCache.tail);

        System.out.println(lruCache.get(2));
        System.out.print("from head ");
        printCache(lruCache.head);
        System.out.print("from tail ");
        printCacheTail(lruCache.tail);


        System.out.println(lruCache.get(1));
        System.out.print("from head ");
        printCache(lruCache.head);
        System.out.print("from tail ");
        printCacheTail(lruCache.tail);

        lruCache.set(5, 5);
        System.out.println(lruCache.get(1));
        System.out.print("from head ");
        printCache(lruCache.head);
        System.out.print("from tail ");
        printCacheTail(lruCache.tail);

        System.out.println(lruCache.get(2));
        System.out.print("from head ");
        printCache(lruCache.head);
        System.out.print("from tail ");
        printCacheTail(lruCache.tail);

        System.out.println(lruCache.get(3));
        System.out.print("from head ");
        printCache(lruCache.head);
        System.out.print("from tail ");
        printCacheTail(lruCache.tail);

        System.out.println(lruCache.get(4));
        System.out.print("from head ");
        printCache(lruCache.head);
        System.out.print("from tail ");
        printCacheTail(lruCache.tail);

        System.out.println(lruCache.get(5));
        System.out.print("from head ");
        printCache(lruCache.head);
        System.out.print("from tail ");
        printCacheTail(lruCache.tail);
    }

    private static void printCache(LinkedList node) {
        int cnt = 0;
        while (node != null && cnt++ < 10) {
            System.out.print(node.key + "->");
            node = node.next;
        }
        System.out.println();
    }
    private static void printCacheTail(LinkedList node) {
        int cnt = 0;
        while (node != null && cnt++ < 10) {
            System.out.print(node.key + "->");
            node = node.prev;
        }
        System.out.println();
    }
}
