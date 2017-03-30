/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 11:44 - 11:52 - 12:13
        int m = nums1.length, n = nums2.length;
        if((m + n) % 2 == 1) {
            return (double)findKth(nums1, 0, nums2, 0, (m + n) / 2 + 1);
        } else {
            return ((double)findKth(nums1, 0, nums2, 0, (m + n) / 2 + 1) + (double)findKth(nums1, 0, nums2, 0, (m + n) / 2)) / 2;
        }
    }
    
    public int findKth(int[] A, int as, int[] B, int bs, int k) {
        if (as == A.length) return B[bs + k - 1];
        if (bs == B.length) return A[as + k - 1];
        if (k == 1) return Math.min(A[as], B[bs]);
        if(as + k / 2 > A.length) {
            return findKth(A, as, B, bs + k / 2, k - k / 2);
        }
        if(bs + k / 2 > B.length) { // typo > instead of <
            return findKth(A, as + k / 2, B, bs, k - k / 2);
        }
        if(A[as + k / 2 - 1] < B[bs + k / 2 - 1]) {
            return findKth(A, as + k / 2, B, bs, k - k / 2);
        } else {
            return findKth(A, as, B, bs + k / 2, k - k / 2);
        }
    }
}
