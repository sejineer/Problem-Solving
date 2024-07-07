import java.util.*;

public class Main {
    static int[] d;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        
        d = new int[number + 1];
        for(int i = 1; i <= number; i++) {
            d[i] = i;
            for(int j = 1; j * j <= i; j++) {
                d[i] = Math.min(d[i], d[i - j * j] + 1);
            }
        }

        System.out.println(d[number]);
    }
}