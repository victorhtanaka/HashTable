public class HashTableBad<K, V> extends HashTable<K, V> {
    @Override
    public V put(K key, V value) {
        Node[] table = this.table;
        Node<K, V> newNode = new Node<>(key, value);
        int pos = generateHash(key);
        if (pos > table.length - 1) {
            increaseTableCapacity();
        }
        if (table[pos] == null) {
            table[pos] = newNode;
        } else {
            handleCollision(newNode, pos);
        }

        return value;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public int generateHash(K key) {
        return 0;
    }

    private void handleCollision(Node<K, V> node, int pos) {
        Node<K, V> currNode = table[pos];
        while (currNode != null) {
            if (currNode.getNext() != null) {
                currNode = currNode.getNext();
            } else {
                currNode.setNext(node);
                currNode = null;
            }
        }
    }
}
