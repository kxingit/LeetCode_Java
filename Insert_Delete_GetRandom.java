/*
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 */
public class RandomizedSet {

    /** Initialize your data structure here. */
    // 12:45 - 1:15
    private List<Integer> list;
    HashMap<Integer, Integer> map;
    public RandomizedSet() {
        list = new ArrayList();
        map = new HashMap();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int idx = map.get(val);
        int lastnum = list.get(list.size() - 1);
        list.set(idx, lastnum);
        map.put(lastnum, idx);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        if(list.size() == 0) return -1;
        Random r = new Random();  
        return list.get(r.nextInt(list.size()));
    }
}

// v2
public class RandomizedSet {
 
    /** Initialize your data structure here. */
    // 1:46 - 1:52
    List<Integer> list;
    HashMap<Integer, Integer> map;
    public RandomizedSet() {
        list = new ArrayList();
        map = new HashMap();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int idx = map.get(val);
        int lastnum = list.get(list.size() - 1);
        list.set(idx, lastnum);
        map.put(lastnum, idx);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        return list.get(r.nextInt(list.size()));
    }
}

// v3
public class RandomizedSet {
    // 10:34 - 10:38
    private List<Integer> list;
    private HashMap<Integer, Integer> map_idx;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList();
        map_idx = new HashMap();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map_idx.containsKey(val)) return false;
        list.add(val);
        map_idx.put(val, list.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map_idx.containsKey(val) == false) return false;
        
        int index = map_idx.get(val);
        int lastnum = list.get(list.size() - 1);
        list.set(index, lastnum);
        list.remove(list.size() - 1);
        map_idx.put(lastnum, index);
        map_idx.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        return list.get(r.nextInt(list.size()));
    }
}

// v4
public class RandomizedSet {
    // 9:26 - 9:41
    List<Integer> list = new ArrayList();
    HashMap<Integer, Integer> map = new HashMap();
    Random r = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val) == false) return false;
        
        int idx = map.get(val);
        
        int lastidx = list.size() - 1;
        int lastval = list.get(lastidx);
        
        list.set(idx, lastval); // insert, then delete -- delete the last element
        map.put(lastval, idx);
        
        list.remove(lastidx); 
        map.remove(val);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}
