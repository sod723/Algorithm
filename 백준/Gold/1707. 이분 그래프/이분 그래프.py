import sys
from collections import deque
input = sys.stdin.readline
K = int(input())

def dfs(node, color):
    visited[node] = color
    for i in graph[node]:
        if not visited[i]:
            a = dfs(i, -color)
            if not a:
                return False
        elif visited[i] == visited[node]:
            return False
    return True

def bfs(node):
    q = deque([node])
    visited[node] = 1
    while q:
        node = q.popleft()
        for i in graph[node]:
            if visited[i] == 0:
                visited[i] = -visited[node]
                q.append(i)
            elif visited[i] == visited[node]:
                return False
    return True

for _ in range(K):
    V, E = map(int, input().split())
    graph = [[] for _ in range(V + 1)]
    visited = [0] * (V + 1)
    for _ in range(E):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    res = True
    for i in range(1, V+1):
        if visited[i]==0:
            if not bfs(i):
                res = False
                break
    if res:
        print("YES")
    else:
        print("NO")


