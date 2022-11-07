package com.hashtableLinkedlist;

public class MapNode<Key, Value> {
    public Key key;
    public Value value;
    public MapNode<Key,Value> next;

    MapNode(Key key, Value value){
        this.key = key;
        this.value = value;
    }

    public String toString(){
        return "[ "+key+" : "+value+" => "+next+" ]";
    }
}
