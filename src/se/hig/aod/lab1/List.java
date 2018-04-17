package se.hig.aod.lab1;

/**
 * Interface for a unsorted list
 *
 * @param <V>
 *
 * @author Joakim Liljeroth
 */

public interface List<V> {

    public void add(V v);

    public V get(int index);

    public void clear();

    public void isEmpty();

    public void remove(int index);

    public int size();

}
