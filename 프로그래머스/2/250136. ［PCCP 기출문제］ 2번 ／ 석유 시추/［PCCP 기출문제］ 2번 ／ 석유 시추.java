import java.util.*;

class Solution {
    static boolean[][] vis;
    static int[] oils;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public int solution(int[][] land) {
        int r = land.length;
        int c = land[0].length;
        
        oils = new int[c];
        vis = new boolean[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(land[i][j] == 1 && !vis[i][j]) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                    
                    Set<Integer> columns = new HashSet<>();
                    columns.add(j);
                    int count = 1;
                    while(!q.isEmpty()) {
                        int[] cur = q.poll();
                        int curR = cur[0];
                        int curC = cur[1];
                        
                        for(int nxt = 0 ; nxt < 4; nxt++) {
                            int nr = curR + dr[nxt];
                            int nc = curC + dc[nxt];
                            if(nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
                            if(vis[nr][nc] || land[nr][nc] != 1) continue;
                            
                            count++;
                            q.add(new int[]{nr, nc});
                            vis[nr][nc] = true;
                            columns.add(nc);
                        }
                    }
                    for(int column : columns) {
                        oils[column] += count;
                    }
                }
            }
        }
        int result = 0;
        for(int oil : oils) {
            result = Math.max(result, oil);
        }
        
        return result;
    }
}