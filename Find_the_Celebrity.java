/*
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
 *
 * Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 *
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
 */
public class Solution extends Relation {
    public int findCelebrity(int n) {
        // 3:57 - 4:05
        int i = 0, j = n - 1;
        int cand = 0;
        while(i < j) {
            if(knows(i, j)) {
                cand = j;
                i++;
            } else {
                cand = i;
                j--;
            }
        }
        
        cand = knows(i, j) ? j : i;
        for(int k = 0; k < n; k++) {
            if(k == cand) continue;
            if(knows(cand, k) || !knows(k, cand)) {
                return -1;
            }
        }
        return cand;
    }
}