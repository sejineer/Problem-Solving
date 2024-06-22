import java.util.*;

class Solution {
    public int findTheWinner(int n, int k) {
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            dq.offer(i);
        }
        
         while(dq.size() != 1) {
             for(int i = k; i > 1; i--) {
                 int num = dq.poll();
                 dq.offer(num);
             }
             dq.poll();
         }
        return dq.poll();
    }
}