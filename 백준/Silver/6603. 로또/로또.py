from collections import deque

def dfs(arr, depth, start, ans):

    if depth == 6:
        print(" ".join(map(str, ans)))
        return
    for i in range(start, len(arr)):
        ans.append(arr[i])
        dfs(arr, depth+1, i+1, ans)
        ans.pop()

while True:
    data = list(map(int, input().split()))
    if data[0] == 0:
        break
    arr = data[1:]
    dfs(arr, 0, 0, [])
    print()