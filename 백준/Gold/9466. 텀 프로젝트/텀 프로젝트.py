import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
T = int(input())

def dfs(v):
    global res
    visited[v] = 1
    cycle.append(v)
    num = graph[v]
    if visited[num]:
        if num in cycle:
            res += cycle[cycle.index(num):]
        return
    else:
        dfs(num)

for _ in range(T):
    N = int(input())# 학생수

    res = []
    graph = [0] + list(map(int, input().split()))
    if N==1:
        print(0)
        continue
    visited = [0] * (N+1)

    for i in range(1, N+1):
        if visited[i] == 0:
            cycle=[]
            dfs(i)

    print(N-len(res))
