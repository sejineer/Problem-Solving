import java.util.*;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (a, b) -> b.getValue().compareTo(a.getValue()));
        String res = "";
        for(Map.Entry<Character, Integer> i : entries) {
            for(int j = 0; j < i.getValue(); j++) {
                res += i.getKey();
            }
        }
        return res;
    }
}