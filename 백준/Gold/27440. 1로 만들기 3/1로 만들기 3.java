import java.util.*;

public class Main {
    static long n;
    static class Pair {
        long value;
        int count;
        public Pair(long value, int count) {
            this.value = value;
            this.count = count;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();

        Set<Long> set = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(n, 0));
        set.add(n);

        while(!queue.isEmpty()) {
            Pair cur = queue.poll();
            if(cur.value == 1) {
                System.out.println(cur.count);
                return;
            }
            if(cur.value % 3 == 0 && !set.contains(cur.value / 3)) {
                queue.offer(new Pair(cur.value / 3, cur.count + 1));
                set.add(cur.value / 3);
            }
            if(cur.value % 2 == 0 && !set.contains(cur.value / 2)) {
                queue.offer(new Pair(cur.value / 2, cur.count + 1));
                set.add(cur.value / 2);
            }
            if(!set.contains(cur.value - 1)) {
                queue.offer(new Pair(cur.value - 1, cur.count + 1));
                set.add(cur.value - 1);
            }
        }
    }
}