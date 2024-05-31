import java.util.*;

class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int[][] dist = new int[105][105];
    int[][] board = new int[105][105];
    class Pair {
        int x, y, dist;
        Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int solution(int[][] maps) {
        int height = maps.length;
        int width = maps[0].length;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                board[i + 1][j + 1] = maps[i][j];
            }
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1, 1, 1));
        dist[1][1] = 1;
        while(!queue.isEmpty()) {
            Pair cur = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 1 || nx > width || ny < 1 || ny > height) continue;
                if(board[ny][nx] == 0) continue;
                if(dist[ny][nx] != 0 && cur.dist + 1 >= dist[ny][nx]) continue;
                queue.add(new Pair(nx, ny, cur.dist + 1));
                dist[ny][nx] = cur.dist + 1;
            }
        }
        if(dist[height][width] == 0) {
            return -1;
        } else {
            return dist[height][width];
        }
    }
}