/*
 * An abbreviation of a word follows the form <first letter><number><last letter>.
 */
public class ValidWordAbbr {
    // 12:55 - 12:57 - 1:02
    String[] dict;
 
    public ValidWordAbbr(String[] dictionary) {
        dict = dictionary;
    }
    
    public boolean isUnique(String word) {
        if(word.length() == 0) {
            int count = 0;
            for(String s : dict) {
                if(s.length() == 0) {
                    count++;
                }
            }
            return count <= 1;
        }
        
        for(String s : dict) {
            if(word.length() == s.length() 
                && word.charAt(0) == s.charAt(0) 
                && word.charAt(s.length() - 1) == s.charAt(s.length() - 1)
                && !word.equals(s)) {
                    return false;
            }
        }
        return true;
    }
}
