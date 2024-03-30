import java.util.*;

abstract class AbstractHashMap<K, V> {
    protected int capacity;
    protected int size;
    protected double maxLoad;

    public AbstractHashMap(double maxLoad) {
        this.maxLoad = maxLoad;
        this.size = 0;
    }

    protected abstract void resize(int newCapacity);

    protected double loadFactor() {
        return (double) size / capacity;
    }


}

class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
    private LinkedList<Map.Entry<K, V>>[] table;

    public ChainHashMap(double maxLoad) {
        super(maxLoad);
        table = (LinkedList<Map.Entry<K, V>>[]) new LinkedList[(int) maxLoad];
        // Initialize table
    }

    @Override
    protected void resize(int newCapacity) {
        // Resize implementation for ChainHashMap
    }

    // Other methods implementation
}

class ProbeHashMap<K, V> extends AbstractHashMap<K, V> {
    private Map.Entry<K, V>[] table;

    public ProbeHashMap(double maxLoad) {
        super(maxLoad);
        table = (Map.Entry<K, V>[]) new Map.Entry[(int) maxLoad];

    }

    @Override
    protected void resize(int newCapacity) {

    }


}

public class Exercise1 {
    public static void main(String[] args) {
        double[] loadFactors = {0.25, 0.5, 0.75};
        Random random = new Random();

        for (double loadFactor : loadFactors) {
            System.out.println("Testing load factor: " + loadFactor);

            ChainHashMap<Integer, String> chainMap = new ChainHashMap<>(loadFactor);
            ProbeHashMap<Integer, String> probeMap = new ProbeHashMap<>(loadFactor);

        }
    }
}
