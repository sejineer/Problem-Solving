import java.util.*;

class Solution {
    public int getMaxLen(int[] nums) {
        int p = 0;
        int n = 0;
        int res = 0;
        int stack = 0;
        for(int num : nums) {
            if(num > 0) {
                p++;
                n = n == 0 ? 0 : n + 1;
            } else if (num < 0) {   
                int temp = p;
                p = n == 0 ? 0 : n + 1;
                n = temp + 1;
            } else {
                p = 0;
                n = 0;
            }
            res = Math.max(res, p);
            System.out.println(p + " " + n);
        }
        return res;
     }
}