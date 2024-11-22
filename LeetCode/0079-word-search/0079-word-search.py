class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        dx = [-1, 1, 0, 0]
        dy = [0, 0, -1, 1]
        def backtracking(x: int, y: int, index: int) -> bool:
            if index == len(word):
                return True      
            if x < 0 or y < 0 or x >= len(board[0]) or y >= len(board) or board[y][x] != word[index]:
                return False
            temp = board[y][x]
            board[y][x] = "#"
            for nxt in range(4):
                nx, ny = x + dx[nxt], y + dy[nxt]
                if backtracking(nx, ny, index + 1):
                    return True
            board[y][x] = temp
            return False
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if backtracking(j, i, 0):
                    return True
        return False
        