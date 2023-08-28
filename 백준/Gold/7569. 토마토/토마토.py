from collections import deque

M, N, H = map(int, input().split())
dx = [0, 1, 0, -1, 0, 0]
dy = [1, 0, -1, 0, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

queue = deque()
dist = [[[-1]* M for _ in range(N)] for _ in range(H)]

def bfs():
    while queue:
        z, y, x = queue.popleft()
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]

            if nx < 0 or ny < 0 or nz < 0 or nx >= M or ny >= N or nz >= H:
                continue
            if graph[nz][ny][nx] == -1:
                continue
            if graph[nz][ny][nx] == 0 :
                graph[nz][ny][nx] = 1
                dist[nz][ny][nx] = dist[z][y][x] + 1
                queue.append([nz, ny, nx])


graph = []
for i in range(H):
    tmp = []
    for j in range(N):
        tmp.append(list(map(int, input().split())))
    graph.append(tmp)

for i in range(H):
    for j in range(N):
        for k in range(M):
            if graph[i][j][k] == 1:
                #visited[i][j][k] = True
                dist[i][j][k] = 0
                queue.append([i, j, k])

bfs()

ans = 0
for i in range(H):
    for j in range(N):
        for k in range(M):
            if graph[i][j][k] == 0 :
                print(-1)
                exit(0)
            ans = max(ans, dist[i][j][k])
print(ans)
