from collections import deque
T = int(input())

def dfs(v):
    if visited[v] == 1:
        return

    if visited[v] == 0:
        visited[v] = 1
        dfs(graph[v])

for _ in range(T):
    N = int(input())
    graph = list(map(int, input().split()))
    q = deque(graph)
    q.appendleft(0)
    graph = list(q)
    visited = [0] * (N + 1)
    cnt = 0
    for i in range(1, N+1):
        if visited[i] == 1:
            continue
        if visited[i] == 0:
            cnt +=1
            dfs(i)
    print(cnt)

