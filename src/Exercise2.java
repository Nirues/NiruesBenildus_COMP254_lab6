import java.util.Comparator;
import java.util.ArrayList;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;

class SortedTableMap<K, V> {
    private List<Map.Entry<K, V>> table;
    private Comparator<K> comp;

    public SortedTableMap(Comparator<K> comp) {
        this.comp = comp;
        table = new ArrayList<>();
    }

    public void put(K key, V value) {
        int index = findIndex(key);
        if (index != -1) {
            table.set(index, new SimpleEntry<>(key, value));
        } else {
            table.add(new SimpleEntry<>(key, value));
            table.sort((a, b) -> comp.compare(a.getKey(), b.getKey()));
        }
    }

    public boolean containsKey(K key) {
        return findIndex(key) != -1;
    }

    private int findIndex(K key) {
        int left = 0;
        int right = table.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            K midKey = table.get(mid).getKey();

            if (comp.compare(midKey, key) == 0) {
                return mid;
            } else if (comp.compare(midKey, key) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}

public class Exercise2 {
    public static void main(String[] args) {
        Comparator<Integer> comparator = Comparator.naturalOrder();
        SortedTableMap<Integer, String> map = new SortedTableMap<>(comparator);

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        System.out.println("Does map contain key 1? " + map.containsKey(1));
        System.out.println("Does map contain key 2? " + map.containsKey(2));
        System.out.println("Does map contain key 4? " + map.containsKey(4));
    }
}
