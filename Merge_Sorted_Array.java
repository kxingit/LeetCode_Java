/*
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 */

public class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
	int i = m - 1, j = n - 1, k = m + n - 1;
	while(i >= 0 && j >= 0) {
	  if(nums1[i] > nums2[j]) {
		nums1[k] = nums1[i];
		i--;
	  } else {
		nums1[k] = nums2[j];
		j--;
	  }
	  k--;
	}
	while (j >= 0) {
	  nums1[k] = nums2[j];
	  j--;
	  k--;
	}
  }
}

// v2
public class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
	// 1:07 - 1:09
	int i = m - 1, j = n - 1, k = m + n - 1;
	while(i >= 0 && j >= 0) {
	  if(nums1[i] > nums2[j]) {
		nums1[k--] = nums1[i--];
	  } else {
		nums1[k--] = nums2[j--];
	  }
	}
	while(j >= 0) {
	  nums1[k--] = nums2[j--];
	}
  }
}

// v3
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 10:27 - 10:30
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
