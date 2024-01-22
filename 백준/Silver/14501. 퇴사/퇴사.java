import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static Task[] tasks = new Task[20];
    static int[] d = new int[20];
    static class Task {
        int day, cost;
        public Task(int day, int cost) {
            this.day = day;
            this.cost = cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            tasks[i] = new Task(day, cost);
        }
        for(int i = 1; i <= n; i++) {
            d[i] = Math.max(d[i], d[i - 1]);
            if(i + tasks[i].day - 1 <= n) {
                d[i + tasks[i].day] = Math.max(d[i + tasks[i].day], d[i] + tasks[i].cost);
            }
        }
        System.out.println(Math.max(d[n], d[n + 1]));
    }
}