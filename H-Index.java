/*
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 *
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
 */
public class Solution {
    public int hIndex(int[] citations) {
        // 4:00 - 4:15
        int res = 0;
        Arrays.sort(citations);
        
        int i = 0, j = citations.length - 1;
        while(i < j) {
            int tmp = citations[i]; 
            citations[i] = citations[j]; // typo: i, j
            citations[j] = tmp;
            i++; j--;
        }
        
        for(i = 0; i < citations.length; i++) {
            if(citations[i] >= i + 1) {
                res++;
            }
        }
        return res;
    }
}

// v2
public class Solution {
    public int hIndex(int[] citations) {
        // 5:27 - 5:47 box int!
        int n = citations.length;
        Integer[] A = new Integer[n];
        for(int i = 0; i < citations.length; i++) A[i] = new Integer(citations[i]); // box int
        
        Arrays.sort(A, Collections.reverseOrder());
        
        int i = 0;
        for(; i < n; i++) {
            if(i >= A[i]) return i;
        }
        return i;
    }
}

// v3
public class Solution {
    public int hIndex(int[] citations) {
        // 5:27 - 5:47 box int!
        int n = citations.length;
        Integer[] A = new Integer[n];
        for(int i = 0; i < citations.length; i++) A[i] = new Integer(citations[i]); // box int
        
        Arrays.sort(A, Collections.reverseOrder());
        
        int i = 0;
        for(; i < n; i++) {
            if(i >= A[i]) break;
        }
        return i;
    }
}

// v4
public class Solution {
    public int hIndex(int[] citations) {
        // 9:02 - 9:04
        int n = citations.length;
        Integer[] A = new Integer[n];
        for(int i = 0; i < n; i++) {
            A[i] = citations[i];
        }
        
        Arrays.sort(A, Collections.reverseOrder());
        
        int i = 0;
        for(; i < n; i++) {
            if(i + 1 > A[i]) break;
        }
        
        return i;
    }
}
