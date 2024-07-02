import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] presents;
    static int[] want;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        presents = new int[n + 1];
        want = new int[m + 1];

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            pq.offer(num);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= m; i++) {
            want[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= m; i++) {
            int cur = pq.poll();
            if(want[i] > cur) {
                System.out.println(0);
                return;
            }
            if(want[i] < cur) {
                pq.offer(cur - want[i]);
            }
        }
        System.out.println(1);
    }
}