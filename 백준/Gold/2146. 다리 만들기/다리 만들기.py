from collections import deque
N = int(input())
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1] # 하 좌 상 우
graph = []
for i in range(N):
    graph.append(list(map(int, input().split())))
visited = [[False]*N for _ in range(N)]
num = 1
res = 1000

def bfs(x, y):
    queue = deque()
    queue.append([x, y])
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx>=N or ny>=N or nx<0 or ny <0:
                continue
            if graph[nx][ny] == 0:
                continue
            if graph[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                graph[nx][ny] = num
                queue.append([nx,ny])


def bfs2(v):
    queue = deque()
    dist = [[-1]*N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            if graph[i][j] == v:
                dist[i][j] = 0
                queue.append([i,j])

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >= N or ny >= N or nx < 0 or ny < 0:
                continue
            if graph[nx][ny] and graph[nx][ny] != v:
                return dist[x][y]
            elif (not graph[nx][ny]) and dist[nx][ny] == -1:
                dist[nx][ny] = dist[x][y] + 1
                queue.append([nx, ny])
    return 1000



for i in range(N):
    for j in range(N):
        if graph[i][j] and not visited[i][j]:
            visited[i][j] = True
            graph[i][j] = num
            bfs(i, j)
            num += 1

for v in range(1, num):
    res = min(res, bfs2(v))
print(res)


