import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    answer = false;
                    break;
                }
            }
        }
        
        if(!stack.isEmpty()) answer = false;

        return answer;
    }
}