package hashtables;

import java.util.LinkedList;

//chaining
public class hashTable {

    private class Entry { // node
        private int key;
        private String value;

        public Entry(int key, String val) {
            this.key = key;
            this.value = val;
        }
    }

    private LinkedList<Entry>[] entries;

    @SuppressWarnings("unchecked")
    hashTable(int capacity) {
        entries = new LinkedList[capacity];
    }

    public void put(int key, String value) {
        var index = hash(key);
        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        var slot = entries[index]; // bucket
        for (var entry : slot) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        var entry = new Entry(key, value);
        slot.addLast(entry);

    }

    public String get(int key) {
        var index = hash(key);
        var slot = entries[index];

        if (slot != null) {
            for (var entry : slot) {
                if (entry.key == key)
                    return entry.value;
            }
        }

        return null;
    }

    public void remove(int key) {
        var index = hash(key);
        var slot = entries[index];
        if (slot != null) {
            for (var entry : slot) {
                if (entry.key == key)
                    slot.remove(entry);
                return;
            }
        }

        if (slot == null)
            throw new IllegalStateException();

        throw new IllegalStateException();
    }

    private int hash(int key) {
        return key % entries.length;
    }
}
