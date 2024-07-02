import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static ArrayList<Edge>[] edges;
    static final long INF = Long.MAX_VALUE;
    static long[] d;
    static class Edge implements Comparable<Edge> {
        Long c;
        int v;
        public Edge(long c, int v) {
            this.c = c;
            this.v = v;
        }
        @Override
        public int compareTo(Edge e) {
            return c.compareTo(e.c);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        edges = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[v].add(new Edge(c, u));
        }

        d = new long[n + 1];
        Arrays.fill(d, INF);
        Queue<Edge> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            int place = Integer.parseInt(st.nextToken());
            d[place] = 0;
            pq.offer(new Edge(0, place));
        }

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(d[cur.v] != cur.c) continue;
            for(Edge nxt : edges[cur.v]) {
                if(d[nxt.v] <= d[cur.v] + nxt.c) continue;
                d[nxt.v] = d[cur.v] + nxt.c;
                pq.add(new Edge(d[nxt.v], nxt.v));
            }
        }
        int res = 1;
        for(int i = 2; i <= n; i++) {
            if(d[i] > d[res]) {
                res = i;
            } else if(d[i] == d[res]) {
                res = Math.min(res, i);
            }
        }
        System.out.println(res + "\n" + d[res]);
    }
}