N = int(input())
arr = list(map(int, input().split()))

ans = [-1] * N
tmp = []

for i in range(N):
    while tmp and arr[tmp[-1]] < arr[i]:
        ans[tmp.pop()] = arr[i]
    tmp.append(i)

print(*ans)