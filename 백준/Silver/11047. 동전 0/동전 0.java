import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[] coins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coins = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }


        int res = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(k / coins[i] > 0) {
                res += k / coins[i];
                k = k % coins[i];
            }
        }
        
        System.out.println(res);
    }
}