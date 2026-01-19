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
interface MapADT<K, V> {
    void put(K key, V value);
    V get(K key);
    void remove(K key);
}


class MyHashTable<K, V> implements MapADT<K, V> {

    private final int SIZE = 10;
    private MyMapNode<K, V>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        buckets = new MyMapNode[SIZE];
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    @Override
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

    @Override
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

    @Override
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
}



public class HashTableBST {

    public static void main(String[] args) {
        String sentence = "To be or not to be";
        MyHashTable<String, Integer> map = new MyHashTable<>();

        for (String word : sentence.toLowerCase().split(" ")) {
            Integer count = map.get(word);
            map.put(word, count == null ? 1 : count + 1);
        }

        System.out.println("Frequency of 'be' = " + map.get("be"));
    }
}

