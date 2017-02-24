/*
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 11:57 - 12:11
        List<Integer> res = new ArrayList();
        HashMap<Integer, Integer> map = new HashMap();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>(
            new Comparator<Map.Entry<Integer, Integer>>() {
                public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                    return e1.getValue() - e2.getValue();
                }
        });
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry);
            } else if (queue.peek().getValue() < entry.getValue()) {
                queue.poll();
                queue.offer(entry);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : queue)
            ans.add(entry.getKey());
        return ans;
    }
}
