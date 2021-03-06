package tsml.classifiers.distance_based.utils.cache;

public class SymmetricCache<A, B> extends Cache<A, A, B> {

    @Override
    public B get(final A firstKey, final A secondKey) {
        B result = super.get(firstKey, secondKey);
        if(result == null) {
            result = super.get(secondKey, firstKey);
        }
        return result;
    }

    @Override
    public void put(final A firstKey, final A secondKey, final B value) {
        super.put(firstKey, secondKey, value);
    }

    @Override
    public boolean remove(final A firstKey, final A secondKey) {
        boolean removed = super.remove(firstKey, secondKey);
        if(!removed) {
            removed = super.remove(secondKey, firstKey);
        }
        return removed;
    }
}
