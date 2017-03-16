/*
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 *
 * For example, given two 1d vectors:
 *
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
 */
public class ZigzagIterator {
    // 5:38 - 5:44
    public int i1, i2;
    List<Integer> v1, v2;
 
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i1 = 0;
        i2 = 0;
        this.v1 = v1;
        this.v2 = v2;
    }
 
    public int next() {
        int res = 0;
        if(i1 == v1.size()){
            res = v2.get(i2);
            i2++;
        } else if(i2 == v2.size()) {
            res = v1.get(i1);
            i1++;
        } else {
            if(i1 == i2) {
                res = v1.get(i1);
                i1++;
            } else {
                res = v2.get(i2);
                i2++;
            }
        }
        return res;
    }
 
    public boolean hasNext() {
        if(i1 < v1.size() || i2 < v2.size()) {
            return true;
        } else {
            return false;
        }
    }
}
 
/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
