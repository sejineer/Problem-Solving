import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // for(int j = 0; j < n; j++) {
        //     for(int i = n - 1; i >= 0; i--) {
        //         pq.add(board[i][j]);
        //     }
        // }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                pq.add(board[i][j]);
            }
        }

        for(int i = 0; i < n - 1; i++) {
            pq.poll();
        }

        System.out.println(pq.poll());
    }
}