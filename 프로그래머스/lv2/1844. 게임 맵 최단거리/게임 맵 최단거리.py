from collections import deque


def solution(maps):

    n = len(maps)
    m = len(maps[0])
    visited = [[False for _ in range(m)] for _ in range(n)]
    
    answer = bfs(maps, visited, 0, 0)
    
    return answer

def bfs(maps, visited, x, y):
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    n = len(maps)
    m = len(maps[0])

    q =deque()
    q.append((x, y, 1))
    visited[x][y] = True
    
    while q:
        x, y, dist = q.popleft()
        if x == n-1 and y == m-1:
            return dist
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
        
            if nx<0 or ny<0 or nx>=n or ny>=m:
                continue
            if not visited[nx][ny] and maps[nx][ny] == 1:
                q.append((nx,ny, dist+1))
                visited[nx][ny] = True
    
    return -1

