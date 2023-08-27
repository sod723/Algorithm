from collections import deque

T = int(input())
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]  # 우 하 상 좌

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    graph[x][y] = 0
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx<0 or ny<0 or nx>=N or ny>=M:
                continue
            if graph[nx][ny] == 1:
                queue.append((nx,ny))
                graph[nx][ny] = 0

for i in range(T):
    M, N, K = map(int, input().split())
    graph = [[0]*M for _ in range(N)]
    for j in range(K):
        a, b = map(int, input().split())
        graph[b][a] = 1

    ans = 0
    for j in range(N):
        for k in range(M):
            if graph[j][k] == 1:
                bfs(j,k)
                ans +=1
    print(ans)


