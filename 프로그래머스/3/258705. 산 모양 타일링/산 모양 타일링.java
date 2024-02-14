import java.util.*;

class Solution {
    public int solution(int n, int[] tops) {
        int[] d = new int[100005];
        int[] p = new int[100005];
        d[0] = 1; p[0] = 1;
        for(int i = 1; i <= n; i++) {
            if(tops[i - 1] == 1) {
                p[i] = (d[i - 1] * 2 + p[i - 1]) % 10007;
                d[i] = (p[i] + d[i - 1]) % 10007;
            } else {
                p[i] = (d[i - 1] + p[i - 1]) % 10007;
                d[i] = (p[i] + d[i - 1]) % 10007;
            }
        }
        return d[n];
    }
}