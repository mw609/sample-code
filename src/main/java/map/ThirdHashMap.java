package map;

public class ThirdHashMap<K, V> {

    class Node<K, V> {
        private K key;

        private V value;

        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    final int DEFAULT_CA = 16;
    final float DEFAULT_LOAD_FA = 0.75f;

    private int size;

    private Node<K, V>[] bucket;

    public ThirdHashMap(int size) {
        bucket = new Node[size];
        size = 0;
    }

    public ThirdHashMap() {
        bucket = new Node[DEFAULT_CA];
        size = 0;
    }

    public int size() {
        return size;
    }

    private int getIndex(K key, int length) {
        int hashCode = key.hashCode();
        int index = hashCode % length;
        return index;
    }

    public V get(K key) {
        int index = getIndex(key, bucket.length);
        Node<K, V> node = bucket[index];
        if (node == null) {
            return null;
        }
        while (node != null) {
            if (node.key.hashCode() == key.hashCode() &&
                    (key == node.key || key.equals(key))) {
                return node.value;

            }
            node = node.next;
        }
        return null;
    }

    public void put(K key, V value) {
        if (size >= bucket.length * DEFAULT_LOAD_FA) {
            resize();
        }
        putValue(key, value, bucket);
    }

    public void remove(K key){
        int index = getIndex(key, bucket.length);
        Node<K, V> node = bucket[index];
        if (node == null) {
            return;
        }
        while (node != null) {
            if (node.key.hashCode() == key.hashCode() &&
                    (key == node.key || key.equals(key))) {

                bucket[index]=null;
                return;
            }
            node = node.next;
        }
    }

    private void resize() {
        Node<K, V>[] newBucket = new Node[bucket.length * 2];
        rehash(newBucket);
        bucket = newBucket;
    }

    private void rehash(Node<K, V>[] newBucket) {
        size = 0;
        for (int i = 0; i < bucket.length; i++) {
            Node<K, V> node = bucket[i];
            if (node == null) {
                continue;
            }
            while (node != null) {
                putValue(node.key, node.value, newBucket);
                node=node.next;
            }
        }
    }

    private void putValue(K key, V value, Node<K, V>[] tables) {
        int index = getIndex(key, tables.length);
        Node node = tables[index];
        if (node == null) {
            tables[index] = new Node<K, V>(key, value);
            size++;
            return;
        }
        while (node != null) {
            if (node.key.hashCode() == key.hashCode() &&
                    (key == node.key || key.equals(key))) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node<K, V> newNode = new Node<K, V>(key, value, tables[index]);
        tables[index] = newNode;
        size++;

    }
}
