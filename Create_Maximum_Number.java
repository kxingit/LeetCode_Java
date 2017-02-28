/*
   Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits. You should try to optimize your time and space complexity.
 */
// TLE: 32 / 102 test cases passed.
public class Solution {
  List<Integer> result = new ArrayList();
  long max = 0;
  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    // 10:47 - 11:21
    List<Integer> solution = new ArrayList();
    long curr = 0;
    getMax(nums1, 0, nums2, 0, k, solution, curr);
    int[] res = new int[result.size()];
    for(int i = 0; i < result.size(); i++) res[i] = result.get(i);
    return res;
  }
  private void getMax(int[] nums1, int start1, int[] nums2, int start2, int k, List solution, long curr) {
    if(solution.size() == k) {
      if(curr > max) result = new ArrayList(solution);
      max = Math.max(max, curr);
      return;
    }
    for(int i = start1; i < nums1.length; i++) {
      solution.add(nums1[i]);
      getMax(nums1, i + 1, nums2, start2, k, solution, curr * 10 + nums1[i]);
      solution.remove(solution.size() - 1);
    }
    for(int i = start2; i < nums2.length; i++) {
      solution.add(nums2[i]);
      getMax(nums1, start1, nums2, i + 1, k, solution, curr * 10 + nums2[i]);
      solution.remove(solution.size() - 1);
    }
  }
}
