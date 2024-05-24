import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville) {
            pq.add(i);
        }
        
        while(!pq.isEmpty()) {
            int first = pq.poll();
            if(first >= K) {
                break;
            } else {
                if(pq.isEmpty()) return -1;
                else {
                    int second = pq.poll();
                    pq.add(first + second * 2);
                    answer++;
                }
            }
        }
        return answer;
    }
}