import java.util.*;

public class Main {
    static int n, m;
    static int arr[] = new int[10];
    static void func(int k, int idx) {
        if(k == m) {
            for(int i = 0; i < m; i++) System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }
        for(int i = idx; i <= n; i++) {
            arr[k] = i;
            func(k + 1, i + 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        func(0, 1);
    }
}