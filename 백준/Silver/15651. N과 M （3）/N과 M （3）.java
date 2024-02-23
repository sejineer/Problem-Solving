import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr = new int[10];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void func(int k) throws IOException {
        if(k == m) {
            for(int i = 0; i < m; i++) bw.write(arr[i] + " ");
            bw.write("\n");
            return;
        }
        for(int i = 1; i <= n; i++) {
            arr[k] = i;
            func(k + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        func(0);
        bw.flush();
    }
}