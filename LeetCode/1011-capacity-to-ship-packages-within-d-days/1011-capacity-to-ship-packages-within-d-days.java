import java.util.*;

class Solution {
    public boolean solve(int target, int[] weights, int days) {
        int count = 1;
        int temp = 0;
        for(int i : weights) {
            if(temp + i> target) {
                temp = 0;
                count++;
            }
            temp += i;
        }
        if(count > days) return false;
        else return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        
        int start = 0;
        int end = 0;
        for(int i : weights) {
            start = Math.max(start, i);
            end += i;
        }
        
        while(start < end) {
            int mid = (start + end) / 2;
            if(solve(mid, weights, days)) end = mid;
            else start = mid + 1;
        }
        
        return end;
    }
}