/*
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 *
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 */
public class TwoSum {
 
    /** Initialize your data structure here. */
    List<Integer> list;
    HashMap<Integer, Integer> map;
    
    public TwoSum() {
        this.list = new ArrayList();
        this.map = new HashMap();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        this.list.add(number);
        if(!this.map.containsKey(number)) {
            this.map.put(number, 1);
        } else {
            this.map.put(number, map.get(number) + 1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int i = 0; i < this.list.size(); i++) {
            int gap = value - list.get(i);
            if(gap == list.get(i) && map.containsKey(gap) && map.get(gap) == 1) {
                continue; 
            }
            if(map.containsKey(gap)) return true;
        }
        return false;
    }
}


// v2
public class TwoSum {
 
    private HashMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(!map.containsKey(number)) {
            map.put(number, 1);
        } else {
            map.put(number, map.get(number) + 1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Integer i : map.keySet()) {
            int gap = value - i;
            if(map.containsKey(gap)) {
                if(i == gap && map.get(i) == 1) continue;
                return true;
            }
        }
        return false;
    }
}
