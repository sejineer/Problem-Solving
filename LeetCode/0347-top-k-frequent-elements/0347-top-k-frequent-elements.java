import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (a, b) -> b.getValue().compareTo(a.getValue()));

        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> i : entries) {
            if(k > 0) {
                res.add(i.getKey());
                k--;
            } else {
                break;
            }
        }
        
        int ansIdx = 0;
        int[] ans = new int[res.size()];
        for(int i : res) {
            ans[ansIdx++] = i;
        }
        return ans;
    }
}