N,M,R = map(int, input().split())
graph = [[] for _ in range(N+1)]
visited = [0]*(N+1)
cnt = 1

for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(v):
    global cnt
    visited[v] = cnt
    graph[v].sort()
    for i in graph[v]:
        if visited[i] == 0:
            cnt +=1
            dfs(i)

def dfs_stack(v):
    global cnt
    stack = [v]
    while stack:
        node = stack.pop()
        if visited[node] != 0:
            continue
        visited[node] = cnt
        cnt+=1
        graph[node].sort(reverse = True)
        for i in graph[node]:
            if visited[i] == 0:
                stack.append(i)


dfs_stack(R)

for i in range(1, N + 1):
    print(visited[i])