import java.util.*;
import java.io.*;

public class Main {
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());

        while(t > 0) {
            String p, temp;
            int n;
            boolean isReverse = false;
            p = br.readLine();
            n = Integer.parseInt(br.readLine());
            Deque<Integer> nums = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                nums.add(Integer.parseInt(token));
            }
            
            boolean error = false;
            for(int i = 0; i < p.length(); i++) {
                if(p.charAt(i) == 'R') {
                    if(!isReverse) {
                        isReverse = true;
                    }
                    else {
                        isReverse = false;
                    }
                } else {
                    if(nums.size() == 0) {
                        sb.append("error\n");
                        error = true;
                        break;
                    }
                    if(!isReverse) {
                        nums.removeFirst();
                    } else {
                        nums.removeLast();
                    }
                }
            }
            if(error) {
                t--;
                continue;
            }
            StringBuilder ans = new StringBuilder("[");
            if(!isReverse) {
                while(!nums.isEmpty()) {
                    int a = nums.pollFirst();
                    ans.append(a + ",");
                }
            } else {
                while(!nums.isEmpty()) {
                    int a = nums.pollLast();
                    ans.append(a + ",");
                }
            }
            if(ans.length() > 2) ans.deleteCharAt(ans.length() - 1);
            ans.append("]");
            sb.append(ans + "\n");            
            t--;
        }
        System.out.println(sb);
    }
}
