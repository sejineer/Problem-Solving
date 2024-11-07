import java.util.*;
import java.io.*;

public class Main {
    static int l, c;
    static String[] sarr;
    static int[] arr = new int[20];
    static boolean[] isUsed = new boolean[20];
    static int j = 0;
    static int m = 0;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void func(int k) throws IOException {
        if(k == l && j >= 2 && m >= 1) {
            for(int i = 0; i < l; i++) {
                bw.write(sarr[arr[i]]);
            }
            bw.write("\n");
        }
        int st = 0;
        if(k != 0) st = arr[k - 1];
        for(int i = st; i < c; i++) {
            if(!isUsed[i]) {
                isUsed[i] = true;
                arr[k] = i;
                if(sarr[i].equals("a") || sarr[i].equals("e") || sarr[i].equals("i") || sarr[i].equals("o") || sarr[i].equals("u")) m++;
                else j++;
                func(k + 1);
                isUsed[i] = false;
                if(sarr[i].equals("a") || sarr[i].equals("e") || sarr[i].equals("i") || sarr[i].equals("o") || sarr[i].equals("u")) m--;
                else j--;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sarr = br.readLine().split(" ");
        Arrays.sort(sarr);
        func(0);
        bw.flush();
    }
}
