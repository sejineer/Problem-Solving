import java.util.*;

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int N = arr.length; int[] d = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            int curMax = 0; int best = 0;
            for(int j = 1; j <= k && i - j >= 0; j++) {
                curMax = Math.max(curMax, arr[i - j]);
                best = Math.max(best, d[i - j] + curMax * j);
            }
            d[i] = best;
        }
        return d[N];
    }
}