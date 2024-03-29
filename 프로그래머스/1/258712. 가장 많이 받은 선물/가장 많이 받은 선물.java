import java.util.*;

class Solution {
    static int[][] board = new int[55][55];
    static int[][] giftIdx = new int[55][3];
    
    public int solution(String[] friends, String[] gifts) {
        final int friendsNum = friends.length;
        Map<String, Integer> friendToIndex = new HashMap<>();
        Map<Integer, String> indexToFriend = new HashMap<>();
        Map<String, Integer> res = new HashMap<>();
        for(int i = 0; i < friends.length; i++) {
            friendToIndex.put(friends[i], i + 1);
            indexToFriend.put(i + 1, friends[i]);
            res.put(friends[i], 0);
        }
        for(String s : gifts) {
            String[] temp = s.split(" ");
            board[friendToIndex.get(temp[0])][friendToIndex.get(temp[1])]++;
        }
        for(int i = 1; i <= friends.length; i++) {
            int count = 0;
            for(int j = 1; j <= friends.length; j++) {
                count += board[i][j];
            }
            giftIdx[i][0] = count;
        }
        for(int j = 1; j <= friends.length; j++) {
            int count = 0;
            for(int i = 1; i <= friends.length; i++) {
                count += board[i][j];
            }
            giftIdx[j][1] = count;
        }
        for(int i = 1; i <= friendsNum; i++) {
            giftIdx[i][2] = giftIdx[i][0] - giftIdx[i][1];
        }
        
        for(int i = 1; i <= friendsNum; i++) {
            for(int j = i + 1; j <= friendsNum; j++) {
                int temp;
                if(board[i][j] > board[j][i]) {
                    temp = res.get(indexToFriend.get(i));
                    res.replace(indexToFriend.get(i), temp + 1);
                } else if (board[j][i] > board[i][j]) {
                    temp = res.get(indexToFriend.get(j));
                    res.replace(indexToFriend.get(j), temp + 1);
                } else {
                    if(giftIdx[i][2] > giftIdx[j][2]) {
                        temp = res.get(indexToFriend.get(i));
                        res.replace(indexToFriend.get(i), temp + 1);
                    } else if(giftIdx[j][2] > giftIdx[i][2]) {
                        temp = res.get(indexToFriend.get(j));
                        res.replace(indexToFriend.get(j), temp + 1);
                    } else {
                        continue;
                    }
                }
            }
        }
        int ans = 0;
        for(int i : res.values()) {
            ans = Math.max(ans, i);
        }
        return ans;
    }
}