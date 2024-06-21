import java.util.*;
import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[] arr;
    static String string;
    static boolean[] isUsed;
    static int index;
    static int count;
    static int max;
    static boolean stop;

    static public void permutation(int k) throws IOException {
        if(k == string.length()) {
            if(count == index) {
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < arr.length; i++) {
                    sb.append(arr[i]);
                }
                stop = true;
                bw.write(sb + "\n");
            }
            count++;
            return;
        }
        if(stop) return;
        for(int i = 0; i < string.length(); i++) {
            if(!isUsed[i]) {
                arr[k] = string.charAt(i);
                isUsed[i] = true;
                permutation(k + 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while((line = br.readLine()) != null && line.length() != 0) {
            bw.write(String.format("%s = ", line));
            StringTokenizer st = new StringTokenizer(line);
            String text = st.nextToken();
            int idx = Integer.parseInt(st.nextToken());

            max = 1;
            for(int i = text.length(); i > 0; i--) max *= i;
            if(idx > max) {
                bw.write("No permutation\n");
                continue;
            }

            string = text;
            arr = new char[text.length()];
            isUsed = new boolean[text.length()];
            index = idx;
            count = 1;
            stop = false;
            permutation(0);
        }
        bw.flush();
    }
}
