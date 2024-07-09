import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static Integer[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new Integer[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int ans = 0;
        int min = 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
            min = arr[i];
            count++;
            ans = Math.max(ans, count * min);
        }

        System.out.println(ans);
    }
}
