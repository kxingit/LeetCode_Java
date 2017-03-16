/*
 * Implement an iterator to flatten a 2d vector.
 */
public class Vector2D implements Iterator<Integer> {
    // 6:02 - 6:20
    int i = 0, j = 0;
    List<List<Integer>> A;
 
    public Vector2D(List<List<Integer>> vec2d) {
        A = vec2d;
    }
 
    @Override
    public Integer next() {
        int res = A.get(i).get(j);
        j++;
        return res;
    }
 
    @Override
    public boolean hasNext() {
        if(A.size() == 0) return false;
        if(i < A.size() && j < A.get(i).size()) {
            return true;
        } else if(j == A.get(i).size()) {
            j = 0;
            i++;
            while(i < A.size()) {
                if(A.get(i).size() != 0) {
                    return true;
                }
                i++;
            }
            return false;
        } else {
            return false;
        }
    }
    
}


