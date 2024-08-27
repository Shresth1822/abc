import java.util.LinkedList;

class KeyValuePair<K, V> {
    K key;
    V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class HashTable<K, V> {
    private int capacity;
    private LinkedList<KeyValuePair<K, V>>[] table;

    public HashTable(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (KeyValuePair<K, V> pair : table[index]) {
            if (pair.key.equals(key)) {
                pair.value = value;
                return;
            }
        }

        table[index].add(new KeyValuePair<>(key, value));
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (KeyValuePair<K, V> pair : table[index]) {
                if (pair.key.equals(key)) {
                    return pair.value;
                }
            }
        }
        throw new IllegalArgumentException("Key not found");
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (KeyValuePair<K, V> pair : table[index]) {
                if (pair.key.equals(key)) {
                    table[index].remove(pair);
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Key not found");
    }

    public boolean contains(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (KeyValuePair<K, V> pair : table[index]) {
                if (pair.key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(100);

        hashTable.put("name", 30);
        hashTable.put("age", 30);
        hashTable.put("city", 1000);

        System.out.println("Value associated with 'name': " + hashTable.get("name"));
        System.out.println("Contains 'age': " + hashTable.contains("age"));

        hashTable.remove("city");
        System.out.println("Contains 'city' after removal: " + hashTable.contains("city"));
    }
}
