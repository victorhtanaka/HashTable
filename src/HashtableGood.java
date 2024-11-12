public class HashtableGood<K, V> extends HashTable<K, V> {

    public HashtableGood() {
        super();
    }

    @Override
    public int hashPos(K key) {
        return Math.abs(key.hashCode()) % this.table.length;
    }
}
