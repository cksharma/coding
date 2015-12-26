package practise;

class MyLinkedList<K, V> {
    private K key;
    private V value;
    private MyLinkedList<K, V> next;

    MyLinkedList(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public MyLinkedList<K, V> getNext() {
        return next;
    }

    public void setNext(MyLinkedList<K, V> next) {
        this.next = next;
    }
}

public class MyHashMap<K, V> {

    private int CAPACITY = 100;
    private int curSize = 0;
    private final double LOAD_FACTOR = 0.8;

    private MyLinkedList[] myList = new MyLinkedList[CAPACITY];

    public V get(K key) {
        int hash = hashCode(key);
        MyLinkedList<K, V> list = myList[hash];

        while (list != null) {
            K tempKey = list.getKey();
            if (key.equals(tempKey)) {
                return list.getValue();
            }
            list = list.getNext();
        }
        return null;
    }

    public void put(K key, V value) {
        if (key == null || value == null)
            throw new RuntimeException("Null key or value not allowed");
        int hash = hashCode(key);
        MyLinkedList<K, V> list = myList[hash];

        if (list == null) {
            myList[hash] = new MyLinkedList<K, V>(key, value);
        } else {
            while (list != null) {
                K listKey = list.getKey();
                //printLinkedList(list);
                if (key.equals(listKey)) {
                    list.setValue(value);
                    return;
                }
                if (list.getNext() == null) {
                    list.setNext(new MyLinkedList<K, V>(key, value));
                    break;
                } else {
                    list = list.getNext();
                }
            }
        }
        curSize++;
        System.out.println("curSize = " + curSize + " CAPACITY =" + CAPACITY);
        if (1. * curSize / CAPACITY >= LOAD_FACTOR) {
            resize();
        }
    }

    private void printLinkedList(MyLinkedList<K, V> list) {
        if (list != null) System.out.print("Value " + list.getValue() + "  ");
        while (list != null) {
            System.out.print(list.getKey() + "----");
            list = list.getNext();
        }
        System.out.println();
    }

    public void resize() {
        MyLinkedList<K, V>[] oldList = new MyLinkedList[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            oldList[i] = myList[i];
        }

        int newCapacity = (int) (CAPACITY * 1.5);
        myList = new MyLinkedList[newCapacity];
        curSize = 0;
        CAPACITY = newCapacity;

        for (int i = 0; i < oldList.length; i++) {
            MyLinkedList<K, V> list = oldList[i];
            if (list == null) continue;
            while (list != null) {
                K key = list.getKey();
                V value = list.getValue();
                put(key, value);
                list = list.getNext();
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CAPACITY; i++) {
            MyLinkedList<K, V> list = myList[i];
            if (list == null) continue;
            sb.append(" { " + list.getKey() + " : " + list.getValue() + " }");
        }
        return sb.toString();
    }

    public int hashCode(K key) {
        return Math.abs(key.toString().hashCode() % CAPACITY);
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        for (int i = 1; i < 10; i++) {
            String key = "key" + i;
            map.put(key, i);
        }
        System.out.println(map.get("key11"));
    }
}
