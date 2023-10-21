from collections import deque

def solution(board):
    answer = -1
    n = len(board)
    m = len(board[0])
    for i in range(n):
        for j in range(m):
            if board[i][j] == 'R':
                start_x, start_y = i, j
            if board[i][j] == 'G':
                end_x, end_y = i, j
    
    def bfs(x, y):
        nonlocal n, m, start_x, start_y, end_x, end_y
        dx = [0, 1, 0, -1]
        dy = [1, 0, -1, 0]
        
        visited = [[False for _ in range(m)] for _ in range(n)]
        q = deque()
        q.append((x, y, 0))
        visited[x][y] = True
        while q:
            x, y, cost = q.popleft()
            if board[x][y] == 'G':
                return cost
            for i in range(4):           
                nx, ny = x, y
                while True:
                    nx = nx + dx[i]
                    ny = ny + dy[i]

                    if 0<=nx<n and 0<=ny<m and board[nx][ny] =='D':
                        nx -= dx[i]
                        ny -= dy[i]
                        break
                    if nx<0 or ny<0 or nx>=n or ny>=m:
                        nx -= dx[i]
                        ny -= dy[i]
                        break

                if not visited[nx][ny]:
                    visited[nx][ny] = True
                    q.append((nx,ny, cost+1))
        return -1
    
    answer = bfs(start_x, start_y)
            
        
    return answer