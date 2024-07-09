import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static class Pair {
        int start, end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Pair[] meetings = new Pair[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Pair(start, end);
        }

        Arrays.sort(meetings, (a, b) -> {
            if(a.end != b.end) {
                return a.end - b.end; 
            } else {
                return a.start - b.start;
            }
        });

        int ans = 0;
        int t = 0;
        for(int i = 0; i < n; i++) {
            if(t > meetings[i].start) continue;
            ans++;
            t = meetings[i].end;
        }

        System.out.println(ans);
    }
}