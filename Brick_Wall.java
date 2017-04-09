/*
There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.

The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.

If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
*/
public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        // 8:35 - 8:46 - 8:54
        int m = wall.size();
        if(m == 0) return 0;
        int n = wall.get(0).size();
        if(n == 0) return 0;
        
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < m; i++) {
            int cumulate = 0;
            for(int j = 0; j < wall.get(i).size() - 1; j++) { // not including the end
                if(j == 0) {
                    cumulate = wall.get(i).get(j);
                } else {
                    cumulate += wall.get(i).get(j);
                }
                map.put(cumulate, map.getOrDefault(cumulate, 0) + 1); 
            }
        }
        
        int maxcount = 0;
        for(Integer val : map.keySet()) {
            int count = map.get(val);
            maxcount = Math.max(maxcount, count);
        }
        
        return m - maxcount;
    }
}
