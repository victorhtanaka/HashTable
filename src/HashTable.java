
public abstract class HashTable<K, V> implements IHashTable<K, V> {
    protected Node<K, V>[] table;
    private int size;

    public HashTable(int capacity) {
        table = new Node[capacity];
    }

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

    protected int incrementSize() {
        return size++;
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
    }
}
