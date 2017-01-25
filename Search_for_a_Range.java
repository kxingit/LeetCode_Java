/*
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4]. 
 */
public class Solution {
  public int[] searchRange(int[] nums, int target) {
	// 12:26 - 12:33
	int result[] = new int[2];
	result[0] = searchFirst(nums, target);
	result[1] = searchLast(nums, target);
	return result;
  }
  private int searchFirst(int[] nums, int target) {
	if(nums.length == 0) return -1;
	int start = 0, end = nums.length - 1;
	while (start + 1 < end) {
	  int mid = start + (end - start) / 2;
	  if(nums[mid] >= target) {
		end = mid;
	  } else {
		start = mid;
	  }
	}
	if(nums[start] == target) {
	  return start;
	} else if (nums[end] == target) {
	  return end;
	} else {
	  return -1;
	}
  }
  private int searchLast(int[] nums, int target) {
	if(nums.length == 0) return -1;
	int start = 0, end = nums.length - 1;
	while (start + 1 < end) {
	  int mid = start + (end - start) / 2;
	  if(nums[mid] <= target) {
		start = mid;
	  } else {
		end = mid;
	  }
	}
	if(nums[end] == target) {
	  return end;
	} else if (nums[start] == target) {
	  return start;
	} else {
	  return -1;
	}
  }
}


