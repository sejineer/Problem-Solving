import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] nums = new int[10];
    static int[] arr = new int[10];
    static boolean[] isUsed = new boolean[10];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void func(int k) throws IOException {
        if(k == m) {
            for(int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
        }
        int tmp = 0;
        for(int i = 0; i < n; i++) {
            if(!isUsed[i] && tmp != nums[i]) {
                isUsed[i] = true;
                arr[k] = nums[i];
                tmp = arr[k];
                func(k + 1);
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
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums, 0, n);
        func(0);
        bw.flush();
    }
}