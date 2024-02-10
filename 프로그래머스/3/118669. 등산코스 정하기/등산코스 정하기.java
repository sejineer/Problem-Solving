import java.util.*;

class Solution {
    static ArrayList<Edge>[] edges;
    static HashSet<Integer> hs = new HashSet<>();
    static class Edge implements Comparable<Edge> {
        int w, v;
        public Edge(int w, int v) {
            this.w = w;
            this.v = v;
        }
        @Override
        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        for(int i = 0; i < gates.length; i++) hs.add(gates[i]);
        for(int i = 0; i < summits.length; i++) hs.add(summits[i]);
        
        edges = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        
        for(int i = 0; i < paths.length; i++) {
            int from = paths[i][0];
            int to = paths[i][1]; 
            int weight = paths[i][2];
            edges[from].add(new Edge(weight, to));
            edges[to].add(new Edge(weight, from));
        }
        
        Queue<Edge> pq = new PriorityQueue<>();
        for(int i = 0; i < gates.length; i++) {
            d[gates[i]] = 0;
            pq.offer(new Edge(d[gates[i]], gates[i]));
        }
        
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(d[cur.v] != cur.w) continue;
            for(Edge nxt : edges[cur.v]) {
                if(d[nxt.v] <= Math.max(d[cur.v], nxt.w)) continue;
                d[nxt.v] = Math.max(d[cur.v], nxt.w);
                if(hs.contains(nxt.v)) continue;
                pq.offer(new Edge(d[nxt.v], nxt.v));
            }
        }
        
        int intensity = Integer.MAX_VALUE;
        int summit = Integer.MAX_VALUE;
        for(int i = 0; i < summits.length; i++) {
            if(d[summits[i]] == intensity) {
                summit = Math.min(summit, summits[i]);
            }
            if(d[summits[i]] < intensity) {
                intensity = d[summits[i]];
                summit = summits[i];
            }
        }
        return new int[] {summit, intensity};
    }
}