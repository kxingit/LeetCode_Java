/*
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        // 4:37 - 4:44
        return sum(nestedList, 1);
    }
    
    public int sum(List<NestedInteger> nestedList, int depth) {
        int res = 0;
        for(int i = 0; i < nestedList.size(); i++) {
            if(nestedList.get(i).isInteger()) {
                res += depth * nestedList.get(i).getInteger();
            } else {
                res += sum(nestedList.get(i).getList(), depth + 1);
            }
        }
        return res;
    }
}
