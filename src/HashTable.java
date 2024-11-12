
public abstract class HashTable<K, V> implements IHashTable<K, V> {
    protected Node<K, V>[] table;
    private int collisions = 0;
    private int size = 0;

    public HashTable() {
        table = new Node[10];
    }

    @Override
    public V remove(K key) {

        return null;
    }

    public int size() {
        return size;
    }

    private void incrementCollisions() {
        collisions++;
    }

    public int getCollisions() {
        return collisions;
    }

    protected void incrementSize() {
        size++;
    }

    protected void increaseTableCapacity() {
        Node<K, V>[] newTable = new Node[table.length * 2];
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                newTable[i] = table[i];
            }
        }
        table = newTable;
    }

    public V put(K key, V value) {
        Node<K, V>[] table = this.table;
        Node<K, V> newNode = new Node<>(key, value);
        int pos = hashPos(key);

        if (table[pos] == null) {
            table[pos] = newNode;
        } else {
            handleCollision(newNode, pos);
        }
        incrementSize();

        if (size() >= table.length * 0.8) {
            increaseTableCapacity();
        }

        return value;
    }

    private void handleCollision(Node<K, V> node, int pos) {
        Node<K, V> currNode = table[pos];

        while (currNode.getNext() != null) {
            currNode = currNode.getNext();
        }
        currNode.setNext(node);
        incrementCollisions();
    }


    public V get(K key) {
        int pos = hashPos(key);
        Node<K, V> currNode = table[pos];

        while (currNode != null) {
            if (currNode.getKey().equals(key)) {
                return currNode.getValue();
            }
            currNode = currNode.getNext();
        }

        return null;
    }

    protected static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        protected Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        protected void setNext(Node<K, V> next) {
            this.next = next;
        }

        protected Node<K, V> getNext() {
            return next;
        }

        public K getKey() {
            return key;
        }
    }
}
