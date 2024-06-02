package Linear.hashtables;

import java.util.Arrays;

public class HashMap {

    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    private Entry[] entries;
    private int count;

    HashMap(int capacity) {
        entries = new Entry[capacity];
    }

    public void put(int key, String value) { // used linear probing with both initial indexing and handling collisions
                                             // bec i will be equal zero at first

        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        if (isFull())
            throw new IllegalStateException();

        entries[getIndex(key)] = new Entry(key, value);
        count++;
    }

    public String get(int key) {
        var entry = getEntry(key);
        return entry != null ? entry.value : null;
    }

    public void remove(int key) {
        var index = getIndex(key);
        if (index == -1 || entries[index] == null)
            return;

        entries[index] = null;
        count--;
    }

    public int size() {
        return count;
    }

    public boolean isFull() {
        return count == entries.length;
    }

    public Entry getEntry(int key) {
        var index = getIndex(key);
        return index >= 0 ? entries[index] : null;
    }

    public int getIndex(int key) {
        int steps = 0;
        while (steps < entries.length) {
            var index = index(key, steps++);
            var entry = entries[index];
            if (entry == null || entry.key == key)
                return index;
        }
        return -1;
    }

    // probing
    public int index(int key, int i) {
        return (hash(key) + i) % entries.length;
    }

    public int hash(int key) {
        return key % entries.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(entries);
    }
}

// 4-
// Build a
// hash table
// from scratch.
// Use linear
// probing strategy for
// handling collisions.
// Implement the
// following operations:-

// put(int, String) - get(int) - remove(int) - size()
// Solution: HashMap