package com.hashtableLinkedlist;

import java.util.Hashtable;

public class HashTable<Key, Value> {
    LinkedList<Key, Value>[] hashArray;
    int capacity = 23;

    /**
     * Create Hash Table data structure
     */
    public HashTable() {
        hashArray = new LinkedList[capacity];
        for(int index = 0; index < capacity; index++) {
            hashArray[index] = new LinkedList<Key, Value>();
        }
    }

    public int hashFunction(Key key) {
        return (key.hashCode() % capacity) >= 0 ? (key.hashCode() % capacity) : -(key.hashCode() % capacity);
    }

    /**
     * put data with key value pair to the hash table
     * key will be unique in hash table
     * it will check hash table already contains data with key or not
     * if contains then it will update that data otherwise create new data with new key
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        hashArray[hashFunction(key)].put(key, value);
    }

    /**
     * check hash table has data with key or not
     *
     * @param key
     * @return true if contains key otherwise false
     */
    public boolean containsKey(Key key) {
        return hashArray[hashFunction(key)].containsKey(key);
    }

    /**
     * get value in hash table which has pair with key
     *
     * @param key
     * @return {@value}
     */
    public Value get(Key key) {
        return hashArray[hashFunction(key)].getKey(key);
    }

    /**
     * take data of each node and wrap it with entry class and return array of entry
     *
     * @return entries
     */
    public Entry<Key, Value>[] all() {
        Entry<Key, Value>[] result = new Entry[size()];
        int count = 0;
        for(int index = 0; index < capacity; index++) {
            Entry<Key, Value>[] tempEntries = hashArray[index].all();
            for(Entry entry : tempEntries) {
                result[count] = entry;
                count++;
            }
        }
        return result;
    }

    public boolean isEmpty() {
        for(int index = 0; index < capacity; index++) if (!hashArray[index].isEmpty()) return false;
        return true;
    }

    /**
     * Return how many number of nodes in hash table
     *
     * @return count of nodes
     */
    public int size() {
        int count = 0;
        for(int index = 0; index < capacity; index++) count += hashArray[index].size();
        return count;
    }

    /**
     * mkae hash table print with its array and linked lists
     */
    private void makePrint() {
        for(int index = 0; index < capacity; index++) {
            System.out.println(index+" == "+hashArray[index].toString());
        }
    }

    public static void main(String[] args) {
        String sentence = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        HashTable<String, Integer> frequencyOfWords = new HashTable<String, Integer>();
        String[] words = sentence.split(" ");
        // Store frequencies of words into Hash Table data structure
        for(String word : words)
            if (frequencyOfWords.containsKey(word)) {
                Integer frequencyOfWord = frequencyOfWords.get(word);
                frequencyOfWord++;
                frequencyOfWords.put(word, frequencyOfWord);
            } else frequencyOfWords.put(word, 1);
        // Show all words frequencies from Hash Table data structure
        for(Entry entry : frequencyOfWords.all()) {
            if (entry != null)
                System.out.println("Frequency of \""+entry.key+"\" in sentence is "+entry.value);
        }
        // have to remove avoidable from sentence
        String wordToRemove = "avoidable";
        try {
            int frequencyOfWordToRemove = frequencyOfWords.get(wordToRemove);
            int beginIndex = 0;
            System.out.println(wordToRemove.length());
            while(frequencyOfWordToRemove > 0) {
                if(sentence.substring(beginIndex, beginIndex + wordToRemove.length()).equals(wordToRemove)) {
                    sentence = sentence.substring(0, beginIndex) + sentence.substring(beginIndex+wordToRemove.length());
                    frequencyOfWordToRemove--;
                } else {
                    beginIndex++;
                }
            }
            System.out.println(sentence);
        } catch (Exception e) {
            System.out.println("Word not found");
        }

    }

}
