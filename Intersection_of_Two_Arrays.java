/*
 * Given two arrays, write a function to compute their intersection.
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 3:39 - 3:50
        Set<Integer> set = new HashSet();
        List<Integer> res = new ArrayList();
        for(int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Arrays.sort(nums2);
        for(int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i]) && (res.size() == 0 || res.get(res.size() - 1) != nums2[i])) {
                res.add(nums2[i]);
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++) result[i] = res.get(i);
        return result;
    }
}

// v2
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 4:07 - 4:11
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList();
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++; j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int n = res.size();
        int[] result = new int[n];
        for(int ii = 0; ii < n; ii++) {
            result[ii] = res.get(ii);
        }
        return result;
    }
}
