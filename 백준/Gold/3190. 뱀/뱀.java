import java.util.*;
import java.io.*;

public class Main {
    static int n, k, l;
    static int[][] board = new int[105][105];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[] way = {'R', 'D', 'L', 'U'};
    static HashMap<Integer, Character> direction = new HashMap<>();
    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            board[y][x] = 1;
        }

        l = Integer.parseInt(br.readLine());
        for(int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            direction.put(time, dir);
        }
        Deque<Pair> deque = new LinkedList<>();
        deque.offerFirst(new Pair(1, 1));
        char mode = 'R';
        int timer = 0;
        while(true) {
            timer++;
            for(int i = 0; i < 4; i++) {
                if(mode != way[i]) continue;
                Pair head = deque.peekFirst();
                int nxtX = head.x + dx[i];
                int nxtY = head.y + dy[i];
                if(nxtX > n || nxtX < 1 || nxtY > n || nxtY < 1 || board[nxtY][nxtX] == 2) {
                    System.out.println(timer);
                    return;
                }
                if(board[nxtY][nxtX] == 1) {
                    board[nxtY][nxtX] = 2;
                    deque.offerFirst(new Pair(nxtX, nxtY));
                } else {
                    board[nxtY][nxtX] = 2;
                    deque.offerFirst(new Pair(nxtX, nxtY));
                    Pair tail = deque.pollLast();
                    board[tail.y][tail.x] = 0;
                }
                if(direction.keySet().contains(timer)) {
                    if(direction.get(timer) == 'L' && mode == 'R') {mode = 'U';}
                    else if(direction.get(timer) == 'D' && mode == 'R') {mode = 'D';}
                    else if(direction.get(timer) == 'L' && mode == 'D') {mode = 'R';}
                    else if(direction.get(timer) == 'D' && mode == 'D') {mode = 'L';}
                    else if(direction.get(timer) == 'L' && mode == 'L') {mode = 'D';}
                    else if(direction.get(timer) == 'D' && mode == 'L') {mode = 'U';}
                    else if(direction.get(timer) == 'L' && mode == 'U') {mode = 'L';}
                    else if(direction.get(timer) == 'D' && mode == 'U') {mode = 'R';}
                }
                break;
            }
        }
    }
}
