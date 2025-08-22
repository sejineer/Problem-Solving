import java.util.*;
import java.io.*;

public class Main {
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        m = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Map<String, List<String>> map = new HashMap<>();
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String value = st.nextToken();
                String type = st.nextToken();
                map.computeIfAbsent(type, k -> new ArrayList<>()).add(value);
            }
            int cal = 1;
            for(List<String> s : map.values()) {
                cal *= s.size() + 1;
            }
            bw.write(String.valueOf(cal - 1) + "\n");
        }

        bw.flush();
    }
}
