import sys
sys.setrecursionlimit(10**6)

N = int(input())
graph = [[] for _ in range(N+1)]


for _ in range(N-1):
    a,b,c = map(int, input().split())
    graph[a].append([b,c])
    graph[b].append([a,c])

def dfs(v, cost):
    for node, weight in graph[v]:
        if visited[node] == -1:
            visited[node] = cost + weight
            dfs(node, cost+weight)

visited = [-1]*(N+1)
visited[1] = 0
dfs(1, 0)

start = visited.index(max(visited))
visited = [-1]*(N+1)
visited[start] = 0
dfs(start, 0)

print(max(visited))
