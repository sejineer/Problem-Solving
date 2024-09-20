import java.util.*;

class Solution {
    public boolean fun(int target, int[] diffs, int[] times, long limit) {
        long total = 0;
        for(int i = 0; i < diffs.length; i++) {
            if(diffs[i] <= target) {
                total += times[i];
            } else {
                int count = diffs[i] - target;
                total += (times[i - 1] + times[i]) * count + times[i];
            }
        }
        return total <= limit;
    }
    public int solution(int[] diffs, int[] times, long limit) {
        
        int start  = 1;
        int end = 100000;
        
        while(start < end) {
            int mid = (start + end) / 2;
            if(fun(mid, diffs, times, limit)) end = mid;
            else start = mid + 1;
        }
        return end;
    }
}