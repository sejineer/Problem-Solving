import java.util.*;

public class Main {
    static int n, m;
    static int[] arr = new int[10];
    static boolean[] isUsed = new boolean[10];
    static void func(int cur) {
        if(cur == m) {
            for(int i = 0; i < m; i++) System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(!isUsed[i]) {
                arr[cur] = i;
                isUsed[i] = true;
                func(cur + 1);
                isUsed[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        func(0);
    }
}