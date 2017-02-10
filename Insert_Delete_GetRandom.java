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
