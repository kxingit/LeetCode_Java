/*
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (new Comparator<int[]>() {
            // @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        }));
        List<int[]> resultList = new LinkedList<>();
        for(int[] cur : people){
            resultList.add(cur[1], cur);
        }
        return resultList.toArray(new int[people.length][]);
    }
}
