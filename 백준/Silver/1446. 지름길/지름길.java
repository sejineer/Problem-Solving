import java.util.*;

public class Main {
    static final int INF = 10001;
    static ArrayList<Edge>[] graph;
    static int[] dist;
    static int N, D;

    static class Edge implements Comparable<Edge> {
        private final int v; // 정점
        private final int w; // 비용

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.w - edge.w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
		N = sc.nextInt();
		D = sc.nextInt();
		
		graph = new ArrayList[D + 1];
		for (int i = 0; i <= D; i++) {
			graph[i] = new ArrayList<>();
			if(i < D){
				graph[i].add(new Edge(i+1, 1)); // 다음 위치로 가는 비용 추가
			}
		}
		
		dist = new int[D + 1];
		for (int i=0; i<N; i++) { 
			int u=sc.nextInt(); 
			int v=sc.nextInt(); 
			int w=sc.nextInt();
			
			if(v <= D){
				graph[u].add(new Edge(v,w));
			}
			
	    }
	    
	    Arrays.fill(dist, INF);
	    dist[0] = 0;

	    PriorityQueue<Edge> pq=new PriorityQueue<>();
	    pq.add(new Edge(0, 0));
	    
	    while(!pq.isEmpty()){
	        Edge cur=pq.poll();
	        
	        if(dist[cur.v] < cur.w) continue;
	        
	        for(Edge next: graph[cur.v]){
	            if(dist[next.v] > dist[cur.v]+next.w){
	                dist[next.v] = dist[cur.v]+next.w;
	                pq.add(new Edge(next.v, dist[next.v]));
	            }
	        }
	    }
	    
	    System.out.println(dist[D]);
    }
}