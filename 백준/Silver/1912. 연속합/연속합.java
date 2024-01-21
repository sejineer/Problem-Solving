import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int nums[] = new int[100005];
    static int d1[] = new int[100005];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, nums[i]);
        }
        if(max < 0) {
            System.out.println(max);
            return;
        }
        d1[1] = nums[1];
        for(int i = 2; i <= n; i++) {
            if(d1[i - 1] + nums[i] >= 0){
                d1[i] = d1[i - 1] + nums[i];
            } else {
                d1[i] = 0;
            }
        }
        int res = 0;
        for(int i = 1; i <= n; i++) {
            res = Math.max(res, d1[i]);
        }
        System.out.println(res);
    }
}