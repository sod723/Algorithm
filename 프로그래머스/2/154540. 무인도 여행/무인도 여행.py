import sys
sys.setrecursionlimit(10000)

def solution(maps):
    answer = []
    maps = [list(i) for i in maps]
    n = len(maps)
    m = len(maps[0])
    day = 0
    visited = [[False for _ in range(m)] for _ in range(n)]
    def dfs(x, y):
        nonlocal day
        dx = [0, 1, 0, -1]
        dy = [1, 0, -1, 0]
        
        if x<0 or y<0 or x>=n or y>=m or visited[x][y] or maps[x][y] == 'X':
            return False
        
        visited[x][y] = True
        day += int(maps[x][y])
        maps[x][y] = 'X'
        
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            dfs(nx, ny)
            
        return True
    
    for i in range(n):
        for j in range(m):
            visited = [[False for _ in range(m)] for _ in range(n)]
            day = 0
            if dfs(i, j):
                answer.append(day)
    
    answer.sort()
    if answer:        
        return answer
    else:
        return [-1]