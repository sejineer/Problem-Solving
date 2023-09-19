import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N; // 아이들 수
    static int M; // 색상의 수
    static Integer[] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        colors = new Integer[M];
        int min = 1;
        int max = 0;
        for (int i = 0; i < M; i++) {
            colors[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, colors[i]);
        }
        Arrays.sort(colors, Comparator.reverseOrder());

        while (min <= max) {
            int mid = (min + max) / 2;
            int count = 0;
            for (int i = 0; i < M; i++) {
                count += colors[i] / mid;
                if(colors[i] % mid != 0) count++;
            }
            if(count > N) min = mid + 1;
            else {
                max = mid - 1;
            }
        }
        System.out.println(min);
    }
}