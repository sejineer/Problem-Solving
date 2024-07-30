import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static int[][] board = new int[305][305];
    static int[][] d = new int[305][305];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                d[i][j] = d[i - 1][j] + d[i][j - 1] + board[i][j] - d[i - 1][j - 1];
            }
        }

        k = Integer.parseInt(br.readLine());
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            res[i] = d[y2][x2] - d[y1 - 1][x2] - d[y2][x1 - 1] + d[y1 - 1][x1 - 1];
        }

        for(int i : res) {
            System.out.println(i);
        }
    }
    
}
