N, M = map(int,input().split())
ans = []

def backTracking(depth):
    if depth == M:
        print(" ".join(map(str, ans)))
        return
    for i in range(1, N+1):
        ans.append(i)
        backTracking(depth+1)
        ans.pop()

backTracking(0)



