public interface IHashTable<K, V> {
    V put(K key, V value);
    V get(K key);
    V remove(K key);
    int size();
    int generateHash(K key);
}
