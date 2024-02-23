import java.util.*;
import java.io.*;
public class Main {
    static int n, s, res;
    static int[] arr = new int[25];
    
    public static void func(int cur, int sum, int count) {
        if(cur == n) {
            if(sum == s && count > 0) res++;
            return;
        }
        func(cur + 1, sum + arr[cur], count + 1);
        func(cur + 1, sum, count);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 0, 0);
        System.out.println(res);
    }
}