/*
 * A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 *
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
 *
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
 */
public class Solution {
    public boolean canCross(int[] stones) {
        // 12:18 - 12:28 - 12:45
        int n = stones.length;
        if(n <= 1) return true;
        if(n == 2) return stones[1] == 1;
        List<HashSet<Integer>> set = new ArrayList();
        for(int i = 0; i < n; i++) {
            set.add(new HashSet<Integer>());
        }
        set.get(1).add(1);
        for(int i = 2; i < n; i++) {
            for(int j = 1; j < i; j++) {
            int currstep = stones[i] - stones[j];
                if(canJump(currstep, set.get(j))) {
                    set.get(i).add(currstep);
                }
            }
        }
        return set.get(n - 1).size() > 0;
    }
    private boolean canJump(int currstep, HashSet<Integer> preset) {
        return preset.contains(currstep) || preset.contains(currstep - 1) || preset.contains(currstep + 1);
    }
}
