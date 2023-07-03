from collections import deque
M, N = map(int, input().split())

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

graph = []
visited = [[False]*M for _ in range(N)]
dist = [[-1]*M for _ in range(N)]

for _ in range(N):
    graph.append(list(map(int, input().split())))

def bfs():
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx>= N or ny >= M or nx<0 or ny < 0:
                continue

            if graph[nx][ny] == -1:
                continue

            if graph[nx][ny] == 0 and not visited[nx][ny]:
                dist[nx][ny] = dist[x][y] + 1
                visited[nx][ny] = True
                queue.append([nx, ny])

queue = deque()

for i in range(N):
    for j in range(M):
        if graph[i][j] == 1:
            visited[i][j] = True
            dist[i][j] = 0
            queue.append([i, j])

bfs()

num = 0
for i in range(N):
    for j in range(M):
        if graph[i][j] == 0 and dist[i][j] == -1:
            print(-1)
            exit(0)
        num = max(num, dist[i][j])
print(num)

