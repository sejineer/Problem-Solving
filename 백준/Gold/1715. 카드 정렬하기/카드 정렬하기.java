import java.util.*;
import java.io.*;

public class Main {
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while(pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            result += num1 + num2;
            pq.add(num1 + num2);
        }
        
        System.out.println(result);
    }
}