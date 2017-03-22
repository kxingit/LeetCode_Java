/*
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
 *
 * Write a function to compute all possible states of the string after one valid move.
 */
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        // 1:06 - 1:09
        List<String> res = new ArrayList();
        
        for(int i = 0; i < s.length() - 1; i++) {
            char[] arr = s.toCharArray();
            if(arr[i] == '+' && arr[i + 1] == '+') {
                arr[i] = '-';
                arr[i + 1] = '-';
                res.add(new String(arr));
            }
        }
        
        return res;
    }
}
