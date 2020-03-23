package ziv_carstvo;

/**
 *
 * @author Matija
 */
public class SimpleHashtable<K, V> {

    public static final int DEFAULT_CAPACITY = 16;
    private int size;
    private TableEntry<K, V>[] table;

    public SimpleHashtable(int capacity) {

        //this.table = (TableEntry<K, V>[]) new TableEntry[nextExpo(capacity)];
        this.table = new TableEntry[findNextExponent(capacity)];
        this.size = 0;
    }

    public SimpleHashtable() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Finds the next exponent of 2
     */
    public static int findNextExponent(int arg) {
        if (arg < 0) {
            throw new IllegalArgumentException(
                    "Can't find next exponent for negative numbers!");
        }
        int expo = 2;

        while (!(arg <= expo)) {
            expo *= 2;
        }
        return expo;

    }

    /**
     * Puts the key-value pair in the table
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        if (value == null) {
            return;
        }
        int slot = slot(key);
        if (table[slot] == null) {
            table[slot] = new TableEntry<>(key, value);
            this.size++;
        } else {
            TableEntry<K, V> current = table[slot];
            while (current.key != key && current.next != null) {
                current = current.next;
            }
            if (current.key == key) {
                current.value = value;
            } else {
                current.next = new TableEntry<K, V>(key, value);
                this.size++;
            }
        }

    }

    /**
     * Gets the value from the table based on the key passed in as an argument
     *
     * @param key
     * @return value
     */
    public V get(K key) {
        if (key == null) {
            return null;
        }

        int slot = slot(key);
        TableEntry<K, V> entry = table[slot];

        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    /**
     * Checks if the table contains the key.
     *
     * @param key
     * @return true or false
     */
    public boolean containsKey(K key) {
        if (key == null) {
            return false;
        }

        int slot = slot(key);
        TableEntry<K, V> entry = table[slot];

        while (entry != null) {
            if (entry.key.equals(key)) {
                return true;
            }
            entry = entry.next;
        }
        return false;
    }

    public boolean containsValue(V value) {
        if (value == null) {
            return false;
        }
        for (TableEntry<K, V> entry : table) {
            while (entry != null) {
                if (entry.value.equals(value)) {
                    return true;
                }
                entry = entry.next;
            }
        }
        return false;
    }

    public void remove(K key) {
        if (key == null) {
            return;
        }

        int slot = slot(key);
        TableEntry<K, V> entry = table[slot];

        if (table[slot].key.equals(key)) {
            table[slot] = table[slot].next;
            this.size--;
        } else {
            while (entry.next != null) {
                if (entry.next.key.equals(key)) {
                    entry.next = entry.next.next;
                    this.size--;
                    break;
                }
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SimpleHashtable(");

        for (int i = 0; i < table.length; i++) {
            TableEntry<K, V> entry = table[i];

            if (entry != null) {
                sb.append(i).append("=>").append(entry.toString()).append(";");
            }
        }
        return sb.append(")").toString();
    }

    private int slot(K key) {
        return Math.abs(key.hashCode()) % table.length;

    }

    private static class TableEntry<K, V> {

        private final K key;
        private V value;
        private TableEntry<K, V> next = null;

        public TableEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("(")
                    .append(key.toString())
                    .append("=>")
                    .append(value.toString())
                    .append(")");
            return next == null
                    ? sb.toString()
                    : sb.append("->")
                            .append(next.toString())
                            .toString();
        }

    }

    public static void main(String[] args) {

        // create collection:
        SimpleHashtable<String, Integer> examMarks = new SimpleHashtable<>(5);

        // fill data:        
        examMarks.put("Ivana", 2);
        examMarks.put("Ante", 2);
        examMarks.put("Jasna", 2);
        examMarks.put("Kristina", 5);
        examMarks.put("Ivana", 5); // overwrites old grade for Ivana

        System.out.println(examMarks);

//        System.out.println(examMarks.containsKey("Ante")); // true
//        System.out.println(examMarks.containsKey("Josip")); // false
//        System.out.println(examMarks.containsValue(2)); // true
//        System.out.println(examMarks.containsValue(3)); // false
        examMarks.remove("Ivana");
        System.out.println(examMarks.containsKey("Ivana"));

        // query collection:
        Integer kristinaGrade = examMarks.get("Kristina");
        System.out.println("Kristina's exam grade is: " + kristinaGrade); // writes: 5

        // What is collection's size? Must be four!
        System.out.println("Number of stored pairs: " + examMarks.size()); // writes: 4
    }

}
