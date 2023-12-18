import java.io.*;
import java.util.*;

public class Main {
    static int n, x, res;
    static int arr[];
    static boolean isExist[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        isExist = new boolean[2000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            if(x - arr[i] > 0 && isExist[x - arr[i]]) {
                res++;
            }
            isExist[arr[i]] = true;
        }
        System.out.println(res);
    }    
}