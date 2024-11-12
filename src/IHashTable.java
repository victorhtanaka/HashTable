public interface IHashTable<K, V> {
    V put(K key, V value);
    V get(K key);
    void remove(K key);
    int hashPos(K key);
}
