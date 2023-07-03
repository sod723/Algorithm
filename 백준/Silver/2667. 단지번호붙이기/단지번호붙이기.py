from collections import deque
N = int(input())
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]
graph = []
for i in range(N):
    graph.append(list(map(int, input())))
visited = [[False]*N for i in range(N)]
num = 1

def bfs(x, y):
    queue = deque()
    queue.append([x, y])
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx>=N or ny>=N or nx<0 or ny<0:
                continue

            if graph[nx][ny] == 0:
                continue

            if graph[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                graph[nx][ny] = num
                queue.append([nx, ny])

for i in range(N):
    for j in range(N):
        if not visited[i][j] and graph[i][j] == 1:
            visited[i][j] = True
            graph[i][j] = num
            bfs(i, j)
            num += 1

ans = [0] * num
for i in range(N):
    for j in range(N):
        if graph[i][j] != 0:
            ans[graph[i][j]] += 1

ans.sort()
ans = ans[1:]
print(num - 1)

for i in ans:
    print(i)



