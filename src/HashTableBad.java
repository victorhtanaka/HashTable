public class HashTableBad<K, V> extends HashTable<K, V> {
    public HashTableBad() {
        super();
    }
    @Override
    public int hashPos(K key) {
        return key.toString().length() % this.table.length;
    }
}
