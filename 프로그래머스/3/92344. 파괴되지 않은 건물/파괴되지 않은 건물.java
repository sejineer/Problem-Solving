class Solution {
    static int[][] d = new int[1005][1005];
    public int solution(int[][] board, int[][] skill) {
        int width = board[0].length;
        int height = board.length;
        for(int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int y1 = skill[i][1];
            int x1 = skill[i][2];
            int y2 = skill[i][3];
            int x2 = skill[i][4];
            int count = skill[i][5];
            if(type == 1) count = -count;
            d[y1][x1] += count;
            d[y1][x2 + 1] -= count;
            d[y2 + 1][x1] -= count;
            d[y2 + 1][x2 + 1] += count;
        }
        for(int i = 0; i < height; i++) {
            for(int j = 1; j < width; j++) {
                d[i][j] += d[i][j - 1];
            }
        }
        for(int i = 1; i < height; i++) {
            for(int j = 0; j < width; j++) {
                d[i][j] += d[i - 1][j];
            }
        }
        int res = 0;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(board[i][j] + d[i][j] > 0) res++;
            }
        }
        return res;
    }
}