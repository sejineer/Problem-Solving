import java.util.*;

public class Main {
    static int n, res;
    static boolean isUsed1[];
    static boolean isUsed2[];
    static boolean isUsed3[];


    static void func(int cur) {
        if(cur == n) {
            res++;
            return;
        }
        for(int i = 0; i < n; i++) {
            if(isUsed1[i] || isUsed2[i + cur] || isUsed3[cur - i + n - 1])
                continue;
            isUsed1[i] = true;
            isUsed2[i + cur] = true;
            isUsed3[cur - i + n - 1] = true;
            func(cur + 1);
            isUsed1[i] = false;
            isUsed2[i + cur] = false;
            isUsed3[cur - i + n - 1] = false;
        }
                
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        isUsed1 = new boolean[n];
        isUsed2 = new boolean[n + n - 1];
        isUsed3 = new boolean[n + n - 1];

        func(0);
        System.out.println(res);
    }
}