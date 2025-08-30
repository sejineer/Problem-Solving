import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int[] route : routes) {
            List<int[]> paths = new ArrayList<>();
            paths.add(new int[]{points[route[0] - 1][1], points[route[0] - 1][0]});
            for(int i = 1; i < route.length; i++) {
                int[] start = points[route[i - 1] - 1];
                int[] end = points[route[i] - 1];
                
                int c = start[1];
                int r = start[0];
                while(r != end[0]) {
                    if(r > end[0]) r--;
                    else r++;
                    paths.add(new int[]{c, r});
                }
                
                while(c != end[1]) {
                    if(c > end[1]) c--;
                    else c++;
                    paths.add(new int[]{c, r});
                }
            }
            int time = 0;
            for(int[] path : paths) {
                String key = time + "," + path[1] + "," + path[0];
                map.put(key, map.getOrDefault(key, 0) + 1);
                time++;
            }
        }
        
        int result = 0;
        for (int count : map.values()) {
            if (count >= 2) {
                result++;
            }
        }
        return result;
    }
}