/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {
    // 12:53 - 1:35 // used = put + get
    int capacity;
    HashMap<Integer, Node> map = new HashMap();
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;
       
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
   
    public int get(int key) {
        if(map.containsKey(key) == false) {
            return -1;
        }
       
        Node curr = map.get(key);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
       
        insert_to_tail(curr);
       
        return map.get(key).value;
       
    }
   
    public void put(int key, int value) {
        if(get(key) != -1) { // use a "get" to put key to tail
            map.get(key).value = value;
            return;
        }
       
        if(map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
       
        Node newnode = new Node(key, value);
        map.put(key, newnode);
        insert_to_tail(newnode);
    }
   
    private void insert_to_tail(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
}

// v2
public class LRUCache {
    // 1:38 - 1:47 - 1:52
    HashMap<Integer, Node> map = new HashMap();
    int capacity;
    Node head, tail;
    class Node {
        int value;
        int key;
        Node prev;
        Node next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }
 
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key) == false) {
            return -1;
        }
        
        Node curr = map.get(key);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        
        insert_to_tail(curr);
        
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        if(get(key) != -1) {
            map.get(key).value = value; // refresh !
            return;
        }
        
        if(map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        Node newnode = new Node(key, value);
        map.put(key, newnode);
        insert_to_tail(newnode);
    }
    
    private void insert_to_tail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
}

// v3
public class LRUCache {
    // 2:11 －2:23
    int capacity;
    class Node {
        int value, key;
        Node next, prev;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    HashMap<Integer, Node> map = new HashMap();
 
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        
        Node curr = map.get(key);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        
        insert_to_tail(curr);
        
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        if(get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        
        if(map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        Node node = new Node(key, value);
        map.put(key, node);
        insert_to_tail(node);
    }
    
    private void insert_to_tail(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }
}


// v4
public class LRUCache {
    // 9:48 - 10:00 - 10:06
    class Node {
        int key, val;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            val = v;
        }
    }
    HashMap<Integer, Node> map = new HashMap();
    int capacity;
    Node head, tail;
 
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail; // !!
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key) == false) {
            return -1;
        }
        
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev; // !!
        
        insert_to_tail(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        if(get(key) != -1) {
            // map.put(key, new Node(key, value));
            map.get(key).val = value;
            return;
        }
        
        if(map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
            // map.remove(key); // wrong!
        }
        
        Node node = new Node(key, value);
        map.put(key, node);
        insert_to_tail(node);
    }
    
    public void insert_to_tail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
}


// v5
public class LRUCache {
    // 10:09 - 10:16 - 10:22
    class Node {
        int key, val;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            val = v;
        }
    }
    int capacity;
    Node tail, head;
    HashMap<Integer, Node> map;
 
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap();
    }
    
    public int get(int key) {
        if(map.containsKey(key) == false) {
            return -1;
        }
        
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        insert_to_tail(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        if(get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        
        Node node = new Node(key, value);
        if(map.size() == capacity) {
            map.remove(head.next.key); // !! key not val
            head.next = head.next.next;
            head.next.prev = head; // !!
        }
        
        insert_to_tail(node);
        map.put(key, node); // !!
    }
    
    public void insert_to_tail(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }
}

// v6
public class LRUCache {
    // 2:46 - 2:57 - 3:23 bugs: need to update both map and list
    class Node {
        int key, value;
        Node pre, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }
     
    int capacity;
    HashMap<Integer, Node> map = new HashMap();
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
 
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }
     
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
         
        insert_to_tail(node);
         
        return map.get(key).value;
    }
     
    public void put(int key, int value) {
        if(get(key) != -1) {
           map.get(key).value = value;  
           return;
        }  
         
        Node node = new Node(key, value);
        map.put(key, node);
        insert_to_tail(node);
 
         
        if(map.size() > capacity) {
            map.remove(head.next.key);
            head.next.next.pre = head;
            head.next = head.next.next;
        }
    }
     
    void insert_to_tail(Node node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }
}
