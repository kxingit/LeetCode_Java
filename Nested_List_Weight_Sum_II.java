/*
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
 */
public class Solution {
    // 10:10 - 10:16
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = getDepth(nestedList);
        
        int weight = depth;
        return getSum(nestedList, weight);
    }
    
    public int getSum(List<NestedInteger> nestedList, int weight) {
        int res = 0;
        for(int i = 0; i < nestedList.size(); i++) {
            if(nestedList.get(i).isInteger()) {
                res += nestedList.get(i).getInteger() * weight;
            } else {
                res += getSum(nestedList.get(i).getList(), weight - 1);
            }
        }
        return res;
    }
    
    public int getDepth(List<NestedInteger> nestedList) {
        int res = 0;
        for(int i = 0; i < nestedList.size(); i++) {
            if(nestedList.get(i).isInteger()) {
                res = Math.max(res, 1);
            } else {
                res = Math.max(res, 1 + getDepth(nestedList.get(i).getList()));
            }
        }
        return res;
    }
}
