import java.util.*;

class Solution {
    public boolean solve(long target, int n, int[] times) {
        int count = 0;
        for(int i : times) {
            count += target / i;
            if(count >= n) break;
        }
        if(count >= n) return true;
        else return false;
    }
    public long solution(int n, int[] times) {        
        Arrays.sort(times);
        
        long start = times[0];
        long end = start * n;
        
        while(start < end) {
            long mid = (start + end) / 2;
            if(solve(mid, n, times)) end = mid;
            else start = mid + 1;
        }
        return end;
    }
}