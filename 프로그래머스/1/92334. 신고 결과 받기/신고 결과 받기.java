import java.util.*;

class Solution {
    static boolean[][] board = new boolean[1005][1005]; 
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> index = new HashMap<>();
        HashMap<Integer, String> indexToString = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        HashMap<String, Integer> ans = new HashMap<>();
        for(int i = 0; i < id_list.length; i++) {
            index.put(id_list[i], i);
            count.put(id_list[i], 0);
            ans.put(id_list[i], 0);
            indexToString.put(i, id_list[i]);
        }
        for(String s : report) {
            String[] split = s.split(" ");
            if(board[index.get(split[0])][index.get(split[1])]) continue;
            board[index.get(split[0])][index.get(split[1])] = true;
            count.put(split[1], count.get(split[1]) + 1);
        }
        
        ArrayList<String> stop = new ArrayList<>();
        for(String s : count.keySet()) {
            if(count.get(s) >= k) stop.add(s);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(String s : stop) {
            for(int i = 0; i < id_list.length; i++) {
                if(board[i][index.get(s)]) ans.put(indexToString.get(i), ans.get(indexToString.get(i)) + 1);
            }
        }
        
        for(String s : id_list) {
            res.add(ans.get(s));
        }
        
        int resIdx = 0;
        int[] result = new int[res.size()];
        for(int i : res) {
            result[resIdx] = i;
            resIdx++;
        }
        
        return result;
    }
}