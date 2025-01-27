package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final K[] keysArray = (K[]) new Object[10];
    private final V[] valuesArray = (V[]) new Object[10];
    private int occupancyRate = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < occupancyRate; i++) {
            if ((key == null && keysArray[i] == null)
                    || Objects.equals(key, keysArray[i])) {
                keysArray[i] = key;
                valuesArray[i] = value;
                return;
            }
        }
        keysArray[occupancyRate] = key;
        valuesArray[occupancyRate] = value;
        occupancyRate++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < occupancyRate; i++) {
            if ((key == null && keysArray[i] == null)
                    || Objects.equals(key, keysArray[i])) {
                return valuesArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return occupancyRate;
    }
}
