from itertools import permutations
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
visited = [False for _ in range(n)]
ans = int(1e9)

def dfs(depth, idx):
    global ans
    if depth == n//2:
        a, b = 0, 0
        for i in range(n):
            for j in range(n):
                if visited[i] and visited[j]:
                    a += arr[i][j]
                elif not visited[i] and not visited[j]:
                    b += arr[i][j]
        ans = min(ans, abs(a-b))
        return

    for i in range(idx, n):
        visited[i] = True
        dfs(depth+1, i+1)
        visited[i] = False
dfs(0, 0)
print(ans)