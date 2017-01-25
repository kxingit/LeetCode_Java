/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.

 * For example,

 * Consider the following matrix:

 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]

 * Given target = 3, return true.
 */
public class Solution {
  public int searchInsert(int[] nums, int target) {
	// 12:35 - 12:39
	int start = 0, end = nums.length - 1;
	while (start + 1 < end) {
	  int mid = start + (end - start) / 2;
	  if(nums[mid] < target) {
		start = mid;
	  } else {
		end = mid;
	  }
	}
	if (nums[start] >= target) {
	  return start;
	} else if (nums[end] >= target) {
	  return end;
	} else {
	  return nums.length;
	}
  }
}
