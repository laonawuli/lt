public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            throw new IllegalArgumentException("s and p cannot be null.");
        }
        
        if (p.length() == 0) {
            return s.length() == 0;
        }
        
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.length() == 0) {
                return false;
            }
            if (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') {
                return false;
            }
            return isMatch(s.substring(1), p.substring(1));
        }
        
        if (isMatch(s, p.substring(2))) {
            return true;
        }
        int i = 0;
        while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch(s.substring(i + 1), p.substring(2))) {
                return true;
            }
            i++;
        }
        return false;
    }
}