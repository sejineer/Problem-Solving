import java.util.*;

class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*') {
                stack.pop();
                continue;
            } else {
                stack.add(s.charAt(i));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(Character c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}