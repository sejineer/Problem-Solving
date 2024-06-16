import java.util.*;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : groupSizes) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            map.put(entry.getKey(), entry.getValue() / entry.getKey());
        }
        
        List<List<Integer>> result = new ArrayList<>();
        boolean[] isUsed = new boolean[groupSizes.length];
        map.forEach((key, value) -> {
            int groupCount = key * value;
            List<Integer> group = new ArrayList<>();
            for(int i = 0; i < groupSizes.length; i++) {
                if(groupSizes[i] == key && !isUsed[i] && groupCount > 0) {
                    group.add(i);
                    isUsed[i] = true;
                    groupCount--;
                }
            }
            for(int i = 0; i < group.size(); i += key) {
                result.add(new ArrayList<>(group.subList(i, i + key)));
            }
        });                  
        return result;
    }
}