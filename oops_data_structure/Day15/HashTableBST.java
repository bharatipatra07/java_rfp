class MyMapNode<K, V> {
    K key;
    V value;
    MyMapNode<K, V> next;

    public MyMapNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
public class MyHashTable<K, V> {

    private final int SIZE = 10;
    private MyMapNode<K, V>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        buckets = new MyMapNode[SIZE];
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        MyMapNode<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        MyMapNode<K, V> newNode = new MyMapNode<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public V get(K key) {
        int index = getIndex(key);
        MyMapNode<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        MyMapNode<K, V> head = buckets[index];
        MyMapNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            MyMapNode<K, V> head = buckets[i];
            while (head != null) {
                System.out.println(head.key + " = " + head.value);
                head = head.next;
            }
        }
    }
}




public class HashTableBST {

    public static void main(String[] args) {
        String paragraph =
                "Paranoids are not paranoid because they are paranoid but " +
                        "because they keep putting themselves deliberately into " +
                        "paranoid avoidable situations";

        MyHashTable<String, Integer> hashTable = new MyHashTable<>();

        String[] words = paragraph.toLowerCase().split(" ");

        for (String word : words) {
            Integer count = hashTable.get(word);
            hashTable.put(word, count == null ? 1 : count + 1);
        }

        System.out.println("Before removing 'avoidable':");
        hashTable.display();

        hashTable.remove("avoidable");

        System.out.println("\nAfter removing 'avoidable':");
        hashTable.display();
    }
}

