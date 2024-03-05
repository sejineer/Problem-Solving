import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] num = new int[10];
    static boolean[] isUsed = new boolean[10];
    static int[] arr = new int[10];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void func(int k, int idx) throws IOException {
        if(k == m) {
            for(int i = 0; i < m; i++) {
                bw.write(num[arr[i]] + " ");
            }
            bw.write("\n");
        }
        for(int i = idx; i < n; i++) {
            if(!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                func(k + 1, i + 1);
                isUsed[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num, 0, n);
        func(0, 0);
        bw.flush();
    }
}