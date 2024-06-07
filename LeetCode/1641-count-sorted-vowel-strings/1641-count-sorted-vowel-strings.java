import java.util.*;

class Solution {
    int[][] d = new int[55][10];
    public int countVowelStrings(int n) {
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 5; j++) {
                d[i][j] = d[i][j - 1] + (i > 1 ? d[i - 1][j] : 1);
            }
        }
        return d[n][5];
    }
}