from collections import deque

dx = [1, 0, -1, 0, 1, 1, -1, -1]
dy = [0, -1, 0, 1, 1, -1, 1, -1]

def bfs(x, y, w, h, num):
    queue = deque()
    queue.append([x, y])
    while queue:
        x, y = queue.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx >= h or ny >= w or nx < 0 or ny < 0:
                continue

            if graph[nx][ny] == 0:
                continue

            if graph[nx][ny] == 1 and not visited[nx][ny]:
                queue.append([nx, ny])
                visited[nx][ny] = True
                graph[nx][ny] = num


while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break

    graph = []
    visited = [[False]*w for _ in range(h)]
    num = 1

    for _ in range(h):
        graph.append(list(map(int, input().split())))

    for i in range(h):
        for j in range(w):
            if not visited[i][j] and graph[i][j] == 1:
                visited[i][j] = True
                graph[i][j] = num
                bfs(i, j, w, h, num)
                num += 1

    print(num - 1)