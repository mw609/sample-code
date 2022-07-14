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

    public void put(K key , V value){
        if(size<=DEFAULT_CAPACITY*DEFAULT_LOAD_FACTOR){
            //扩容
            resize();
        }
        putValue(key,value,buckets);
    }
    private void resize(){
        Node<K , V>[] newBuckets = new Node[DEFAULT_CAPACITY*2];
        rehash(newBuckets);
        buckets=newBuckets;
    }
    private void rehash(Node<K, V>[] newBuckets){
        size=0;
        for(int i=0;i<buckets.length;i++){
            if(buckets[i]==null){
                continue;
            }
            Node<K,V> node = buckets[i];
            while (node!=null){
                putValue(node.key,node.value,newBuckets);
                node = node.next;
            }
        }
    }

    private void putValue(K key , V value , Node<K , V>[]table){
        int index = getIndex(key, table.length);
        Node node = table[index];
        if(node == null){
            table[index] = new Node<K, V>(key,value);
            size++;
            return;
        }
        while (node !=null){
            if(node.key.hashCode()==key.hashCode() && (node.key==key || node.key.equals(key))){
                node.value=value;
                return;
            }
            node=node.next;
        }
        Node newNode = new Node(key,value,table[index]);
        table[index] = newNode;
        size++;

    }

    public V get(K key){
        int index = getIndex(key, buckets.length);
        Node<K , V> node = buckets[index];
        if(node == null){
            return null;
        }
        while (node!=null){
            if(node.key.hashCode()==key.hashCode() && (node.key ==key || node.key.equals(key) )){
               return node.value;
            }
            node=node.next;
        }
        return null;
    }
    public int size(){
        return size;
    }
}
