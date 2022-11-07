package com.hashtableLinkedlist;

public class Entry<Key, Value> {
    public Key key;
    public Value value;

    /**
     * Create class and wrap key value pair data into that
     *
     * @param key
     * @param value
     */
    Entry(Key key, Value value) {
        this.key = key;
        this.value = value;
    }
}
