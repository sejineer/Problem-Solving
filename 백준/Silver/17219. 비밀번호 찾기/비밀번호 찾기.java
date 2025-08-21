import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        Map<String, String> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String id = st.nextToken();
            String password = st.nextToken();
            map.put(id, password);
        }

        for(int i = 0; i < m; i++) {
            String q = br.readLine();
            bw.write(map.get(q) + "\n");
        }

        bw.flush();
    }
}
