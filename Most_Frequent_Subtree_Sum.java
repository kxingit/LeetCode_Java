/*
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 */
public class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        // 6:19 - 6:55
        HashMap<Integer, Integer> counts = new HashMap(); // sum : count
        dfs(root, counts);
        int max = Integer.MIN_VALUE;
        for(Integer count : counts.keySet()) {
            max = Math.max(max, counts.get(count));
        }
        List<Integer> res = new ArrayList();
        for(Integer count : counts.keySet()) {
            if(counts.get(count) == max) {
                res.add(count);
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    private int dfs(TreeNode node, HashMap<Integer, Integer> counts) {
        if(node == null) return 0;
        if(node.left == null && node.right == null) {
            if(counts.containsKey(node.val)) {
                counts.put(node.val, counts.get(node.val) + 1);
            } else {
                counts.put(node.val, 1);
            }
            return node.val;
        }
        int sum = node.val + dfs(node.left, counts) + dfs(node.right, counts);
        if(counts.containsKey(sum)) {
            counts.put(sum, counts.get(sum) + 1);
        } else {
            counts.put(sum, 1);
        }
        return sum;
    }
}
