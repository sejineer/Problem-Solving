import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] i : edge) {
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }
        
        int[] dist = new int[n + 1];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dist[1] = 1;
        
        int max = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int i : graph.get(cur)) {
                if(dist[i] > 0) continue;
                dist[i] = dist[cur] + 1;
                max = Math.max(max, dist[i]);
                queue.add(i);
            }
        }
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == max) count++;
        }
        return count;
    }
}