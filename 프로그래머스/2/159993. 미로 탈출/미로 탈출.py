from collections import deque

def solution(maps):
    answer = -1
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j] == 'S':                    
                start_x, start_y = i, j
                break
        if 'S' in maps[i]:
            break

    def bfs(x, y, end, mid):
        visited = [[False for _ in range(len(maps[0]))] for _ in range(len(maps))]        
        q = deque()
        q.append((x, y, 0))
                    
        while q:
            x, y, cost = q.popleft()
            
            for i in range(4):
                nx = x+dx[i]
                ny = y+dy[i]
                
                if nx<0 or ny<0 or nx>=len(maps) or ny >=len(maps[0]):
                    continue
                
                if maps[nx][ny] == end:
                    return cost + 1
                    
                if not visited[nx][ny] and (maps[nx][ny] == 'O' or maps[nx][ny] == mid):
                    q.append((nx, ny, cost + 1))
                    visited[nx][ny] = True
        return -1

    a = bfs(start_x, start_y, 'L', 'E')
    
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j] == 'L':                    
                start_x, start_y = i, j
                break
        if 'L' in maps[i]:
            break

    b = bfs(start_x, start_y, 'E', 'S')
    
    if a != -1 and b != -1:
        answer = a + b
    else:
        answer = -1
    
    return answer
