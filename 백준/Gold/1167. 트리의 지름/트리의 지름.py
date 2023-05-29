from collections import deque

N = int(input())
graph = [[] for _ in range(N+1)]
for _ in range(N):
    data = list(map(int, input().split()))
    idx = 0
    S = data[idx]
    idx += 1
    while True:
        E = data[idx]
        if E == -1:
            break
        V = data[idx+1]
        graph[S].append((E,V))
        idx+=2

visited = [False] * (N+1)
distance = [0] * (N+1)
def bfs(v):
    queue = deque()
    queue.append(v)
    visited[v] = True
    while queue:
        node = queue.popleft()
        for i in graph[node]:
            if not visited[i[0]]:
                visited[i[0]] = True
                queue.append(i[0])
                distance[i[0]] = distance[node] + i[1]

bfs(1)
Max = 1
for i in range(2, N+1):
    if distance[Max] < distance[i]:
        Max = i

visited = [False] * (N+1)
distance = [0] * (N+1)
bfs(Max)
distance.sort()
print(distance[-1])
