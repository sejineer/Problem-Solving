import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[] level;
    public static boolean solve(long target) {
        long sum = 0;
        for(int i = 0; i < n; i++) {
            if(target > level[i]) {
                sum += target - level[i];
            }
        }
        if(sum <= k) return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        level = new int[n];

        for(int i = 0; i < n; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(level);

        long start = 1;
        long end = 2_000_000_000L;

        while(start < end) {
            long mid = (start + end + 1) / 2;
            if(solve(mid)) start = mid;
            else end = mid - 1;
        }

        System.out.println(end);
    }
}