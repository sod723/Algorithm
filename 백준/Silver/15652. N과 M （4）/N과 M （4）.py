n, m = map(int, input().split())
ans = []
def dfs(depth, start):
    if depth == m:
        print(' '.join(map(str, ans)))
        return
    for i in range(start, n+1):

        ans.append(i)
        dfs(depth+1, i)
        ans.pop()

dfs(0, 1)
