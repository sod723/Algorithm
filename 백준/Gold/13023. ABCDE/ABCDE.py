import sys
sys.setrecursionlimit(10000)
N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (N + 1)
arrive = False


def dfs(v, depth):
    global arrive
    if depth == 5:
        arrive = True
        return
    visited[v] = True
    if not arrive:
        for i in graph[v]:
            if not visited[i]:
                dfs(i, depth+1)
    visited[v] = False

for i in range(1, N+1):
    dfs(i,1)
    if arrive:
        break

if arrive:
    print(1)
else:
    print(0)