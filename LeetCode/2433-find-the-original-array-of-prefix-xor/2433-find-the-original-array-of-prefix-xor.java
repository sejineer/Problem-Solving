import java.util.*;

class Solution {
    public int[] findArray(int[] pref) {
        int[] res = new int[pref.length];
        int[] d = new int[pref.length];
        res[0] = pref[0];
        d[0] = pref[0];

        for(int i = 1; i < pref.length; i++) {
            res[i] = d[i - 1] ^ pref[i];
            d[i] = d[i - 1] ^ res[i];
        }
        
        return res;
    }
}