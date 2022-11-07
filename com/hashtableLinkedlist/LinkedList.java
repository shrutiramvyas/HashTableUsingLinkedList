package com.hashtableLinkedlist;

import java.util.Map;

public class LinkedList<Key, Value> {
    MapNode<Key , Value> head;

    LinkedList(){
        head=null;
    }

    public void put(Key key, Value value){
        MapNode newNode = new MapNode<Key, Value>(key, value);
        if(isEmpty()){
            head = newNode;
            return;
        }
        if(head.key.equals(key)){
            newNode.next = head.next;
            head = newNode;
            return;
        }
        MapNode<Key, Value> currentNode = head;
        while(currentNode != null){
            if(currentNode.next.key.equals(key)){
                newNode.next = currentNode.next.next;
                currentNode.next = newNode;
                return;
            }
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }
    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        else{
            return false;
        }
    }
    public Value getKey(Key key){
        if(isEmpty()){
            return null;
        }
        if(head.key.equals(key)){
            return head.value;
        }
        MapNode<Key, Value> currentNode = head;
        while(currentNode.next != null){
            if(currentNode.next.key.equals(key)){
                return currentNode.next.value;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
    public Entry<Key, Value>[] all() {
        Entry<Key, Value>[] result = new Entry[size()];
        MapNode<Key, Value> currentNode = head;
        int index = 0;
        while(currentNode != null) {
            result[index] = new Entry<Key, Value>(currentNode.key, currentNode.value);
            currentNode = currentNode.next;
            index++;
        }
        return result;
    }

    public boolean containsKey(Key key){
        if(isEmpty()){
            return false;
        }
        if(head.key.equals(key)){
            return true;
        }
        MapNode<Key, Value> currentNode = head;
        while(currentNode.next != null) {
            if(currentNode.next.key.equals(key)) return true;
            currentNode = currentNode.next;
        }
        return false;
    }


    public int size() {
        int count = 0;
        MapNode<Key, Value> currentNode = head;
        while(currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    public String toString() {
        if(!isEmpty())	return head.toString();
        else return "null";
    }

}
