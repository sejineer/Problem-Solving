import java.util.*;

class Solution {
    public int minAddToMakeValid(String s) {
        int left = 0; int right = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                right++;
            } else if(right > 0) {
                right--;
            } else {
                left++;
            }
        }
        return left + right;
    }
}