import java.util.*;
import java.io.*;

class Main {
    static int n;
    static class Pair {
        int num, absNum;
        public Pair(int num, int absNum) {
            this.num = num;
            this.absNum = absNum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        Queue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.absNum == o2.absNum) {
                return o1.num - o2.num;
            } else {
                return o1.absNum - o2.absNum;
            }
        });
        
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(pq.isEmpty()) {
                    bw.write(0 + "\n");
                } else {
                    Pair cur = pq.poll();
                    bw.write(cur.num + "\n");
                }
                continue;
            } else {
                pq.add(new Pair(num, Math.abs(num)));
            }
        }
        bw.flush();
    }
}