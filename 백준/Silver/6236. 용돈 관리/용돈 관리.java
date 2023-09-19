import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        money = new int[n];
        int min = 1, max = 0;

        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(in.readLine());
            min = Math.max(min, money[i]);
            max += money[i];
        }

        int res = max;
        int mid;
        while (min <= max) {
            mid = (min + max) / 2;
            if(solution(mid) > m) min = mid + 1;
            else {
                max = mid - 1;
                res = Math.min(res, mid);
            }
        }
        System.out.println(res);
    }

    private static int solution(int price) {
        int count = 1;
        int currentPrice = price;
        for (int i = 0; i < n; i++) {
            if (money[i] > currentPrice) {
                currentPrice = price;
                count++;
                currentPrice -= money[i];
                continue;
            }
            if (money[i] <= currentPrice) {
                currentPrice -= money[i];
            }
        }
        return count;
    }
}