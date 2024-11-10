public class HashtableGood<K, V> extends HashTable<K, V> {
    @Override
    public V put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);

    }
    @Override
    public V get(K key) {
        return null;
    }
    @Override
    public int generateHash(K key) {
        return 0;
    }
}
