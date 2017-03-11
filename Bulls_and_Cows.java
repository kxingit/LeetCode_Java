/*
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 */
public class Solution {
    public String getHint(String secret, String guess) {
        // 11:56 - 12:02
        int[] scount = new int[10];
        for(int i = 0; i < secret.length(); i++) {
            scount[secret.charAt(i) - '0']++;
        }
        
        int cowbull = 0;
        for(int i = 0; i < guess.length(); i++) {
            char num = guess.charAt(i);
            if(scount[num - '0'] > 0) {
                scount[num - '0']--;
                cowbull++;
            }
        }
        
        int bull = 0;
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bull++;
            }
        }
        
        int cow = cowbull - bull;
        return bull + "A" + cow + "B";
    }
}
