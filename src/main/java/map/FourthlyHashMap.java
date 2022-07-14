package map;

public class FourthlyHashMap<K , V> {

   class Node<K , V>{
       private K key;

       private V value;

       private Node<K , V> next;

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

    final int DEFAULT_CAPACITY = 16;

    final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int size;

    Node<K , V>[] buckets;

    public FourthlyHashMap() {
      buckets = new Node[DEFAULT_CAPACITY];
      size = 0;
    }

    public FourthlyHashMap(int size) {
        buckets = new Node[size];
    }

    private int getIndex(K key , int length){
        int hash = key.hashCode();
        int index = hash%length;
        return Math.abs(index);
    }

    public V getValue(K key){
        int index = getIndex(key,size);
        if(buckets[index] == null){
            return null;
        }
        Node<K,V> node = buckets[index];
        while (node !=null){
            if(node.key.hashCode()==key.hashCode() && (node.key.equals(key) || node.key == key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
}
