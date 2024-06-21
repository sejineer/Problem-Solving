import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static String before, after;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        before = sc.nextLine();
        after = sc.nextLine();

        Map<Character, Integer> map = new HashMap<>();
        StringBuilder s = new StringBuilder();
        for(int i = 1; i < before.length() - 1; i++) {
            map.put(before.charAt(i), map.getOrDefault(before.charAt(i), 0) + 1);
            if(before.charAt(i) != 'a' && before.charAt(i) != 'e' && before.charAt(i) != 'i' && before.charAt(i) != 'o' && before.charAt(i) != 'u') {
                s.append(before.charAt(i));
            }
        }
        char first = before.charAt(0);
        char last = before.charAt(before.length() - 1);

        if(after.charAt(0) != first || after.charAt(after.length() - 1) != last) {
            System.out.println("NO");
            return;
        }

        Map<Character, Integer> map2 = new HashMap<>();
        StringBuilder s2 = new StringBuilder();
        for(int i = 1; i < after.length() - 1; i++) {
            map2.put(after.charAt(i), map2.getOrDefault(after.charAt(i), 0) + 1);
            if(after.charAt(i) != 'a' && after.charAt(i) != 'e' && after.charAt(i) != 'i' && after.charAt(i) != 'o' && after.charAt(i) != 'u') {
                s2.append(after.charAt(i));
            }
        }

        if(!(s.compareTo(s2) == 0)) {
            System.out.println("NO");
            return;
        }
        for(Map.Entry<Character, Integer> i : map.entrySet()) {
            if(!Objects.equals(i.getValue(), map2.get(i.getKey()))) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}