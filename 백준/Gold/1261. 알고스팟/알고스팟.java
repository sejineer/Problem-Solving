import java.util.*;
import java.io.*;

public class Main {
    static int m, n;
    static int [][] board = new int[105][105];
    static int[][] dist = new int[105][105];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static final int INF = Integer.MAX_VALUE;
    static class Node implements Comparable<Node>{
        int w, x, y;
        public Node(int w, int x, int y) {
            this.w = w;
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Node node) {
            return this.w - node.w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++) {
            String s = br.readLine();
            for(int j = 1; j <= m; j++) {
                board[i][j] = s.charAt(j - 1) - '0';
                dist[i][j] = INF;
            }
        }

        Queue<Node> pq = new PriorityQueue<>();
        dist[1][1] = 0;
        pq.offer(new Node(0, 1, 1));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(dist[cur.y][cur.x] != cur.w) continue;
            for(int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(ny > n || ny < 1 || nx > m || nx < 1) continue;
                int nw = cur.w + board[ny][nx];
                if(nw < dist[ny][nx]) {
                    dist[ny][nx] = nw;
                    pq.offer(new Node(nw, nx, ny));
                }
            }
        }

        System.out.println(dist[n][m]);
    }
}