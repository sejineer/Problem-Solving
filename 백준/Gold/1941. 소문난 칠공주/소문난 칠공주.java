import java.util.*;
import java.io.*;

public class Main {
    static char[][] board = new char[5][5];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[] visited = new boolean[25];
    static int result = 0;

    static void comb(int idx, int depth) {
        if(depth == 7) {
            if(isValid()) {
                result++;
            }
            return;
        }
        
        for(int i = idx; i < 25; i++) {
            visited[i] = true;
            comb(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    static boolean isValid() {
        List<Integer> list = new ArrayList<>();
        int sCount = 0;
        for(int i = 0; i < 25; i++) {
            if(visited[i]) {
                list.add(i);
                int x = i / 5;
                int y = i % 5;
                if(board[x][y] == 'S') {
                    sCount++;
                }
            }
        }

        if(sCount < 4) {
            return false;
        }

        return isConnected(list);
    }

    static boolean isConnected(List<Integer> list) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] checked = new boolean[7];
        queue.offer(list.get(0));
        checked[0] = true;
        int connectedCount = 1;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            int x = curr / 5;
            int y = curr % 5;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int next = nx * 5 + ny;

                if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && visited[next]) {
                    int index = list.indexOf(next);
                    if(!checked[index]) {
                        checked[index] = true;
                        queue.offer(next);
                        connectedCount++;
                    }
                }
            }
        }

        return connectedCount == 7;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++) {
            String s = br.readLine();
            for(int j = 0; j < 5; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        comb(0, 0);
        System.out.println(result);
    }
}