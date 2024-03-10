import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] nums = new int[10];
    static int[] arr = new int[10];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void func(int k) throws IOException {
        if(k == m) {
            for(int i = 0; i < m; i++) {
                bw.write(nums[arr[i]] + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i = 0; i < n; i++) {
            arr[k] = i;
            func(k + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums, 0, n);
        func(0);
        bw.flush();
    }
}