package com.hashmap;

import java.util.HashMap;

/**
 * Author Bryan.C <br>
 * Date 2018/7/18 15:41
 */
public class LRUHashMapCache<K, V> {
    class Node {
        Node pre;
        Node next;
        K key;
        V val;

        Node() {
        }

        Node(K k, V v) {
            key = k;
            val = v;
        }
    }

    HashMap<K, Node> map = new HashMap<K, Node>();
    // The head (eldest) of the doubly linked list.
    Node head;
    // The tail (youngest) of the doubly linked list.
    Node tail;
    int cap;

    public LRUHashMapCache(int capacity) {
        cap = capacity;
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.pre = head;
    }

    public V get(K key) {
        Node n = map.get(key);
        if (n != null) {
            n.pre.next = n.next;
            n.next.pre = n.pre;
            appendTail(n);
            return n.val;
        }
        return null;
    }

    public void set(K key, V value) {
        Node n = map.get(key);
        // existed
        if (n != null) {
            n.val = value;
            map.put(key, n);
            n.pre.next = n.next;
            n.next.pre = n.pre;
            appendTail(n);
            return;
        }
        // else {
        if (map.size() == cap) {
            Node tmp = head.next;
            head.next = head.next.next;
            head.next.pre = head;
            map.remove(tmp.key);
        }
        n = new Node(key, value);
        // youngest node append taill
        appendTail(n);
        map.put(key, n);
    }

    private void appendTail(Node n) {
        n.next = tail;
        n.pre = tail.pre;
        tail.pre.next = n;
        tail.pre = n;
    }

}
