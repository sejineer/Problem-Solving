import java.util.*;
import java.io.*;

public class Main {
    static int n, m, g, r;
    static int[][] map = new int[55][55];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Point> can = new ArrayList<>();
    static List<List<Point>> selected = new ArrayList<>();
    static List<List<Integer>> green = new ArrayList<>();
    static int result = 0;
    static void pointComb(int idx, List<Point> current) {
        if(current.size() == g + r) {
            selected.add(new ArrayList<>(current));
            return;
        }
        for(int i = idx; i < can.size(); i++) {
            current.add(can.get(i));
            pointComb(i + 1, current);
            current.remove(current.size() - 1);
        }
    }
    static void greenComb(int idx, List<Integer> current) {
        if(current.size() == g) {
            green.add(new ArrayList<>(current));
            return;
        }
        for(int i = idx; i < g + r; i++) {
            current.add(i);
            greenComb(i + 1, current);
            current.remove(current.size() - 1);
        }
    }
    static int bfs(List<Point> points, List<Integer> greens) {
        int[][] mapType = new int[n + 5][m + 5];
        int[][] timeMap = new int[n + 5][m + 5];

        Queue<State> queue = new LinkedList<>();
        for(int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            if(greens.contains(i)) {
                mapType[p.y][p.x] = 1;
                queue.offer(new State(p.x, p.y, 0, 1));
            } else {
                mapType[p.y][p.x] = 2;
                queue.offer(new State(p.x, p.y, 0, 2));
            }
        }

        int flowerCount = 0;
        while(!queue.isEmpty()) {
            State cur = queue.poll();
            if(mapType[cur.y][cur.x] == 3) continue;

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if(map[ny][nx] == 0) continue;
                if(mapType[ny][nx] == 3) continue;

                if(mapType[ny][nx] == 0) {
                    mapType[ny][nx] = cur.type;
                    timeMap[ny][nx] = cur.time + 1;
                    queue.offer(new State(nx, ny, cur.time + 1, cur.type));
                } else if(mapType[ny][nx] != cur.type && timeMap[ny][nx] == cur.time + 1) {
                    mapType[ny][nx] = 3;
                    flowerCount++;
                }
            }
        }

        return flowerCount;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    can.add(new Point(j, i));
                }
            }
        }

        pointComb(0, new ArrayList<>());
        greenComb(0, new ArrayList<>());

        for(List<Point> i : selected) {
            for(List<Integer> j : green) {
                int flowers = bfs(i, j);
                result = Math.max(result, flowers);
            }
        }

        System.out.println(result);
    }
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class State {
        int x, y;
        int time;
        int type; // 1: Green, 2: Red
        public State(int x, int y, int time, int type) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.type = type;
        }
    }
}
