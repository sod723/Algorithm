n = int(input())
arr = list(map(int, input().split()))

dp = []
dp1 = [1 for _ in range(n)]
dp2 = [1 for _ in range(n)]

for i in range(n):
    for j in range(i):
        if arr[i]> arr[j]:
            dp1[i] = max(dp1[i], dp1[j] + 1)
arr.reverse()

for i in range(n):
    for j in range(i):
        if arr[i] > arr[j]:
            dp2[i] = max(dp2[i], dp2[j] + 1)
dp2.reverse()
for i in range(n):
    dp.append(dp1[i] + dp2[i])
print(max(dp) - 1)
