import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < progresses.length; i++) {
            map.put(i, progresses[i]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            q.add(i);
        }
        
        
        while(!q.isEmpty()) {
            int count = 0;
            for(int i : q) {
                map.put(i, map.get(i) + speeds[i]);
            }
            while(!q.isEmpty()) {
                if(map.get(q.peek()) >= 100) {
                    q.poll();
                    count++;
                } else {
                    break;
                }
            }
            if(count > 0) {
                res.add(count);
            }
        }
        int idx = 0;
        int[] answer = new int[res.size()];
        for(int i : res) {
            answer[idx++] = i;
        }
        return answer;
    }
}