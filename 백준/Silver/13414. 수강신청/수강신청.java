import java.util.*;
import java.io.*;

public class Main {
    static int k, l;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        LinkedHashMap<String, Boolean> students = new LinkedHashMap<>();

        for(int i = 0; i < l; i++) {
            String id = br.readLine();
            if(students.containsKey(id)) {
                students.remove(id);
            }
            students.put(id, true);
        }

        int count = 0;
        for (String id : students.keySet()) {
            if(count >= k) break;
            bw.write(id + "\n");
            count++;
        }
        bw.flush();
    }
}
