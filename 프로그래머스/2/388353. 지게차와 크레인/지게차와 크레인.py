from collections import deque

def solution(storage, requests):
    board = [['0'] * (len(storage[0]) + 2) for _ in range(len(storage) + 2)]
    for i in range(len(storage)):
        for j in range(len(storage[0])):
            board[i + 1][j + 1] = storage[i][j]
    
    def twice(target):
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == target:
                    board[i][j] = '0'
    
    def once(target):
        que = deque()
        dx = [1, -1, 0, 0]
        dy = [0, 0, 1, -1]
        vis = [[False] * (len(storage[0]) + 2) for _ in range(len(storage) + 2)]
        que.append([0, 0])
        
        while que:
            x, y = que.popleft()
            for nxt in range(len(dx)):
                nx = x + dx[nxt]
                ny = y + dy[nxt]
                if nx < 0 or ny < 0 or nx >= len(board[0]) or ny >= len(board):
                    continue
                if vis[ny][nx]:
                    continue
                if board[ny][nx] != '0' and board[ny][nx] != target:
                    continue
                
                vis[ny][nx] = True
                if board[ny][nx] == target:
                    board[ny][nx] = '0'
                else:
                    que.append((nx, ny))
                
    for request in requests:
        if len(request) == 1:
            once(request)
        else:
            twice(request[0])
                  
    result = 0
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] != '0':
                result += 1
    return result
