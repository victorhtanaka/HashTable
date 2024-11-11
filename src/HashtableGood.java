public class HashtableGood<K, V> extends HashTable<K, V> {

    public HashtableGood(int size) {
        super(10);
    }

    public HashtableGood() {
        super();
    }

    @Override
    public int hashPos(K key) {
        return Math.abs(key.hashCode()) % this.table.length;
    }
}
